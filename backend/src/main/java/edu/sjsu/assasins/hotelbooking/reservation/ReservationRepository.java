package edu.sjsu.assasins.hotelbooking.reservation;

import edu.sjsu.assasins.hotelbooking.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
