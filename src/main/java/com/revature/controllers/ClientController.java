package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.business.BusinessDelegate;
import com.revature.dto.AuthenticationDTO;
import com.revature.dto.InterviewDTO;
import com.revature.dto.JobDTO;
import com.revature.pojos.Interview;
import com.revature.pojos.User;

@RestController
public class ClientController {

	@Autowired
	BusinessDelegate business;
	
	
	@RequestMapping(value = "/authenticate")
	public ResponseEntity<User> authenticate(AuthenticationDTO auth) {
		return business.authenticate(auth);
	}
	
	@RequestMapping(value = "/home")
<<<<<<< HEAD
	public ResponseEntity<List<Interview>> home(Integer userId) {
		//------------------------------
		// Dummy Data
		
		// User bob
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
		
		//------------------------------
		
		// Actual code
		
		// IMPORTANT
		// FOR TESTING PURPOSES
		// YOU NEED TO CHECK OUT WHAT ID HIBERNATE GAVE TO BOB
		// SO LIKE, IT MIGHT BE 50, OR 100.  CHECK YOUR SQL DEVELOPER.
		List<Interview> list = interviewRepo.findByUser(userRepo.findOneByUserId(50));
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
=======
	public ResponseEntity<List<Interview>> getInterviewsFor(Integer userId) {
		return business.getInterviewsFor(userId);
	}

	@RequestMapping(value = "/jobs")
	public ResponseEntity<List<JobDTO>> dummyJobs() {
		return business.dummyJobs();
>>>>>>> a61007c114251f1e9404d03f44efd170236e1cd2
	}
	
	@RequestMapping(value = "/interviews")
	public ResponseEntity<List<InterviewDTO>> dummyInterviews() {
		return business.dummyInterviews();
	}
	
}
