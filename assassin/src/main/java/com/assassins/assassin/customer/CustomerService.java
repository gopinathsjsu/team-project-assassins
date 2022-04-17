package com.assassins.assassin.customer;

import com.assassins.assassin.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> hello() {
        return customerRepository.findAll();
    }

    private static String get_SHA_1_SecurePassword(String passwordToHash,
                                                   String salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }

    private static String getSalt() throws NoSuchAlgorithmException {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt.toString();
    }

    public void register(Customer customer) throws NoSuchAlgorithmException {
        Optional<Customer> customerByEmail =  customerRepository.findCustomerByEmail(customer.getEmail());
        if(customerByEmail.isPresent()) throw new IllegalStateException("email taken");
        else {
            String securePassword = BCrypt.hashpw(customer.getPassword(), BCrypt.gensalt(12));
//            String securePassword = get_SHA_1_SecurePassword(customer.getPassword(), getSalt());
            customer.setPassword(securePassword);
            customerRepository.save(customer);
        }
    }
}
