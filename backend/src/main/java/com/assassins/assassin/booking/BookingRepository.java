package com.assassins.assassin.booking;

import com.assassins.assassin.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> fetchBookingsByRoomId(int roomId);

    List<Booking> fetchBookingsByRoomIdAndDate(int roomId, LocalDate date);
}