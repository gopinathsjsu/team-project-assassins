package edu.sjsu.assasins.hotelbooking.hotelrooms;

import edu.sjsu.assasins.hotelbooking.models.HotelRoom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelRoomController {
    @Autowired
    private HotelRoomService hotelRoomService;
    @RequestMapping(method= RequestMethod.GET,value="/hotelroom/{id}")
    public List<HotelRoom> getAllRoom(@PathVariable int id){
        System.out.println("test123");
       return hotelRoomService.getAllRoom(id);
    }
    @RequestMapping(method= RequestMethod.POST,value="/hotelroom")
    public String addRoom(@RequestBody HotelRoom h ){
        hotelRoomService.addHotelRoom(h);
        return "hotel rooms added";
    }
}
