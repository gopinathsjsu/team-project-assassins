package edu.sjsu.assasins.hotelbooking.booking;

import edu.sjsu.assasins.hotelbooking.models.Booking;
import edu.sjsu.assasins.hotelbooking.models.ErrorMessage;
import edu.sjsu.assasins.hotelbooking.models.Price;
import edu.sjsu.assasins.hotelbooking.models.Room;
import edu.sjsu.assasins.hotelbooking.price.PriceRepository;
import edu.sjsu.assasins.hotelbooking.room.RoomRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.NoSuchAlgorithmException;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.util.*;

;

@Service
public class BookingService {
     private static final Logger logger = LogManager.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;

     @Autowired
    private PriceRepository priceRepository;

    @Autowired
    private RoomRepository roomRepository;

    public List<Booking> findAll() throws NoSuchAlgorithmException {
        return bookingRepository.findAll();
    }

    public Optional<Booking> findById(String id) throws NoSuchAlgorithmException {
        return bookingRepository.findById(id);
    }

    public List<Booking> findByUserId(String userId) throws NoSuchAlgorithmException {
        return bookingRepository.findByUserId(userId);
    }

}