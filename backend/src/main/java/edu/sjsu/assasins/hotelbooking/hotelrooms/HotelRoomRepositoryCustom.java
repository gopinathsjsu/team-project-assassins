package edu.sjsu.assasins.hotelbooking.hotelrooms;

import edu.sjsu.assasins.hotelbooking.models.HotelRoom;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface HotelRoomRepositoryCustom {
    List<HotelRoom> findAllRoomByHotelid(int hid);
}
