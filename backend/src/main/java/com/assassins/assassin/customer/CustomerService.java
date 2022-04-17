package com.assassins.assassin.customer;

import com.assassins.assassin.models.Customer;
import com.assassins.assassin.util.SHA512Hasher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final SHA512Hasher sha512Hasher = new SHA512Hasher();;
    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

//    CustomerService() {
//        sha512Hasher = new SHA512Hasher();
//    }

    public List<Customer> hello() {
        return customerRepository.findAll();
    }

    public void register(Customer customer) throws NoSuchAlgorithmException {
        Optional<Customer> customerByEmail =  customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerByEmail.isPresent()) throw new IllegalStateException("email taken");
        else {
            System.out.println(customer.getPassword());
            String securePassword = sha512Hasher.hash(customer.getPassword());
            System.out.println(securePassword);
            customer.setPassword(securePassword);
            customerRepository.save(customer);
        }
    }
}
