package edu.sjsu.assasins.hotelbooking.reservation;

import edu.sjsu.assasins.hotelbooking.models.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    public ReservationController() {
    }

    @GetMapping("/booking/{roomId}")
    public ResponseEntity<List<Reservation>> get(@PathVariable int roomId,
                                                 @RequestParam(required = false)
                                             @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        List<Reservation> bookings;
        if (date == null)
            bookings = reservationService.getBookingsByRoomId(roomId);
        else
            bookings = reservationService.getBookingsByRoomIdAndDate(roomId, date);
        return ResponseEntity.ok().body(bookings);
    }
}



