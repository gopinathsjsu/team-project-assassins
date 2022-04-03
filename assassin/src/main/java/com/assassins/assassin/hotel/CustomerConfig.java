package com.assassins.assassin.hotel;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class CustomerConfig {
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository) {
        return args -> {
            Customer c1 = new Customer("ara", "ara");
            Customer c2 = new Customer("aa", "aa");
            customerRepository.saveAll(List.of(c1, c2));
        };
    }
}
