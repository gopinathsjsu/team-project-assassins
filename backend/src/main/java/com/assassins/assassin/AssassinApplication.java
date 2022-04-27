package com.assassins.assassin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
public class AssassinApplication {
	public static void main(String[] args) {
		SpringApplication.run(AssassinApplication.class, args);
	}
}
