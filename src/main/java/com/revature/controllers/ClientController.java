package com.revature.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dto.AuthenticationDTO;
import com.revature.pojos.User;

@RestController
public class ClientController {

	@RequestMapping(value = "/authenticate")
	public ResponseEntity<User> authenticate(AuthenticationDTO auth) {
		User user = new User();
		// TODO
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
}
