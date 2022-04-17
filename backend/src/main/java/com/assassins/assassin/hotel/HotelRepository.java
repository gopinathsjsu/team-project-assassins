package com.assassins.assassin.hotel;

import com.assassins.assassin.models.Hotel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface HotelRepository extends CrudRepository<Hotel,Integer> {

}
