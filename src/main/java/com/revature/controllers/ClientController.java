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
	
	@RequestMapping(value = "/interviews")
	public ResponseEntity<List<InterviewDTO>> dummyInterviews() {
		return business.dummyInterviews();
	}
	
}
