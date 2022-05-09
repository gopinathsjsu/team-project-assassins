package edu.sjsu.assasins.hotelbooking.booking;

import edu.sjsu.assasins.hotelbooking.models.Booking;
import edu.sjsu.assasins.hotelbooking.models.ErrorMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    public BookingController( BookingService bookingService ) {
        this.bookingService = bookingService;
    }

     @RequestMapping(value = "main" , method = RequestMethod.GET)
    public ResponseEntity<Object> main(){
        return ResponseEntity.ok().body(new ErrorMessage("The Booking application is up and running..."));
    }

    @RequestMapping(value = "/getallbookings", method = RequestMethod.GET)
    public ResponseEntity<Object> getAllBookings() throws NoSuchAlgorithmException {
        List<Booking> bookings = bookingService.findAll();
        return ResponseEntity.ok().body(bookings);
    }

     @RequestMapping(value = "/getSpecificBooking/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBookingById(@PathVariable String id) throws NoSuchAlgorithmException {
        Optional<Booking> room = bookingService.findById(id);
        return ResponseEntity.ok().body(room);
    }

    @RequestMapping(value = "/getCustomerBookings/{customerId}", method = RequestMethod.GET)
    public ResponseEntity<Object> getCustomerBookings(@PathVariable String customerId) throws NoSuchAlgorithmException {
        List<Booking> bookings = bookingService.findByUserId(customerId);
        return ResponseEntity.ok().body(bookings);
    }

    @RequestMapping(value = "/getUpdatedPrice", method = RequestMethod.POST)
    public ResponseEntity<Object> getUpdatedPrice(@RequestBody Booking booking) throws NoSuchAlgorithmException {
        var dynamicPriceResponse = bookingService.fetchUpdatedPrice(booking);
        return ResponseEntity.ok().body(dynamicPriceResponse);
    }

    @RequestMapping(value = "/editBooking/{bookingId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> editBooking(@PathVariable String bookingId, @RequestBody Booking booking) throws ParseException {
        bookingService.editBooking(booking, bookingId);
        return new ResponseEntity("Booking updated successfully", HttpStatus.OK);
    }

    public ResponseEntity<Object> cancelBooking(String bookingId)
    {
        if(bookingRepository.existsById(bookingId)){
            try {
                Booking bookingToBeUpdated = bookingRepository.findById(bookingId).get();
                bookingToBeUpdated.setStatus("cancelled");
                bookingRepository.save(bookingToBeUpdated);
                logger.info("Booking record updated: " + bookingId);
                return ResponseEntity.ok(bookingToBeUpdated);
            } catch (Exception e) {
                throw e;
            }
        }
        else {
            logger.error("Booking record does not exists.");
            return ResponseEntity.badRequest().body(new ErrorMessage("Booking record does not exists."));
        }
    }

}