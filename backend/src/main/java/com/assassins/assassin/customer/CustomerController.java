package com.assassins.assassin.customer;

import com.assassins.assassin.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/customer")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> hello() {
        return customerService.hello();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public void registerCustomer(@RequestBody Customer customer) {
        customerService.register(customer);
    }
}
