package edu.sjsu.assasins.hotelbooking.hotelrooms;

import edu.sjsu.assasins.hotelbooking.models.HotelRoom;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelRoomService {
    @Autowired
    private HotelRoomRepository hotelRoomRepository;
    public List<HotelRoom> getAllRoom(int i){return hotelRoomRepository.findAllRoomByHotelid(i);
    }
    public void addHotelRoom(HotelRoom h){
        hotelRoomRepository.save(h);
    }
}
