package com.assassins.assassin.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class HotelController {
    private final HotelService hotelService;

    @Autowired
    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public List<Customer> hello() {
        return hotelService.hello();
    }

    @PostMapping
    public void registerCustomer(@RequestBody Customer customer) {
        hotelService.register(customer);
    }
}
