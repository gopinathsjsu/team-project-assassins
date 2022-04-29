package edu.sjsu.assasins.hotelbooking.hotelrooms;


import edu.sjsu.assasins.hotelbooking.models.HotelRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Service;



@Service
public interface HotelRoomRepository extends JpaRepository<HotelRoom, Integer>,HotelRoomRepositoryCustom {


}
