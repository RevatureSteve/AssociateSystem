package com.revature.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.dto.AuthenticationDTO;
import com.revature.pojos.User;

@Service
public class AuthenticationService {

	/**
	 * Authenticates a user by checking if the provided info (stored in "auth") is in the database.
	 * @param auth DTO containing username and password entered.
	 * @return A user on success, or null on fail.
	 */
	public ResponseEntity<User> authenticate(AuthenticationDTO auth) {
		User user = new User();
		// TODO
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
}
