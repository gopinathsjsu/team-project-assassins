package com.assassins.assassin.hotel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelService {

    private final CustomerRepository customerRepository;

    @Autowired
    public HotelService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> hello() {
        return customerRepository.findAll();
    }

    public void register(Customer customer) {
        Optional<Customer> customerByEmail =  customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerByEmail.isPresent()) throw new IllegalStateException("email taken");
        else customerRepository.save(customer);
    }
}
