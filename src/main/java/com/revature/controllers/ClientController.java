package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.InterviewRepo;
import com.revature.dao.UserRepo;
import com.revature.dto.AuthenticationDTO;
import com.revature.pojos.Interview;
import com.revature.pojos.User;

@RestController
public class ClientController {

	@Autowired
	private InterviewRepo interviewRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@RequestMapping(value = "/authenticate")
	public ResponseEntity<User> authenticate(AuthenticationDTO auth) {
		User user = new User();
		// TODO
		return new ResponseEntity<>(user, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value = "/home")
	public ResponseEntity<List<Interview>> home(Integer userId) {
//		//------------------------------
//		// Dummy Data
//		
//		// User bob
//		User bob = new User();
//		bob.setUserUsername("bob");
//		bob.setUserPassword("123");
//		userRepo.save(bob);
//		
//		// Bob's interview
//		Interview i1 = new Interview();
//		i1.setUser(bob);
//		i1.setInterviewMarketer("joe");
//		interviewRepo.save(i1);
//		
//		// Bob's other interview
//		Interview i2 = new Interview();
//		i2.setUser(bob);
//		i2.setInterviewMarketer("joey");
//		interviewRepo.save(i2);
//		
//		// Not Bob's interview
//		Interview i3 = new Interview();
//		i3.setInterviewMarketer("rainer");
//		interviewRepo.save(i3);
//		
//		//------------------------------
		
		// Actual code
		
		// IMPORTANT
		// FOR TESTING PURPOSES
		// YOU NEED TO CHECK OUT WHAT ID HIBERNATE GAVE TO BOB
		// SO LIKE, IT MIGHT BE 50, OR 100.  CHECK YOUR SQL DEVELOPER.
		List<Interview> list = interviewRepo.findByUser(userRepo.findOneByUserId(100));
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
}
