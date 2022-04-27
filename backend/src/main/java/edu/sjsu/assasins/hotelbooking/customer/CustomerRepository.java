package edu.sjsu.assasins.hotelbooking.customer;

import edu.sjsu.assasins.hotelbooking.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
    List<Customer> findCustomerByEmail(String email);
}
