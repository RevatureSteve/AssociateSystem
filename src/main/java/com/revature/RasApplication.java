package com.revature;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.dao.AccountRepo;

@SpringBootApplication
public class RasApplication {

	public static void main(String[] args) {
		SpringApplication.run(RasApplication.class, args);
	}
}
