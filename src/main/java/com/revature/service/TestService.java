package com.revature.service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.revature.dao.InterviewRepo;
import com.revature.dao.UserRepo;
import com.revature.dto.InterviewDTO;
import com.revature.dto.JobDTO;
import com.revature.pojos.Account;
import com.revature.pojos.Client;
import com.revature.pojos.Interview;
import com.revature.pojos.User;

@Service
public class TestService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	InterviewRepo interviewRepo;
	
	/**
	 * Returns a list of hard-coded interview DTOs.
	 * Excellent...for display.
	 * 
	 * @return A list of hard-coded interview DTOs.
	 */
	public ResponseEntity<List<InterviewDTO>> dummyInterviews() {
		// Generates dummy InterviewDTOs for a demo
		Account a2 = new Account();
		a2.setAccountName("ITC");
		
		Client c2 = new Client();
		c2.setClientName("Walmart");
		
		JobDTO j2 = new JobDTO();
		j2.setJobId(102);
		j2.setAccount(a2);
		j2.setClient(c2);
		j2.setJobCity("Orlando");
		j2.setJobState("Florida");
		j2.setJobTimestamp(new Timestamp(System.currentTimeMillis()));
		j2.setJobTitle("Jr. Java Developer");
		
		InterviewDTO i1 = new InterviewDTO();
		i1.setInterviewId(101);
		i1.setJob(j2);
		i1.setInterviewTime(new Timestamp(System.currentTimeMillis()));
		i1.setInterviewFeedback("Outrageous work.");
		i1.setInterviewType("Skype");
		i1.setInterviewJobNumber(101);
		
		List<InterviewDTO> list = new ArrayList<>();
		list.add(i1);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Returns a list of hard-coded job DTOs.
	 * Excellent...for display.
	 * 
	 * @return A list of hard-coded job DTOs.
	 */
	public ResponseEntity<List<JobDTO>> dummyJobs() {
		// Generates dummy JobDTOs for a demo
		Account a1 = new Account();
		a1.setAccountName("Wipro");
		Account a2 = new Account();
		a2.setAccountName("ITC");
		
		Client c1 = new Client();
		c1.setClientName("Wipro");
		Client c2 = new Client();
		c2.setClientName("Walmart");
		
		JobDTO j1 = new JobDTO();
		j1.setJobId(101);
		j1.setAccount(a1);
		j1.setClient(c1);
		j1.setJobCity("Plano");
		j1.setJobState("Texas");
		j1.setJobTimestamp(new Timestamp(System.currentTimeMillis() + (1000*3600)));
		
		JobDTO j2 = new JobDTO();
		j2.setJobId(102);
		j2.setAccount(a2);
		j2.setClient(c2);
		j2.setJobCity("Orlando");
		j2.setJobState("Florida");
		j2.setJobTimestamp(new Timestamp(System.currentTimeMillis() + (2000*3600)));
		
		List<JobDTO> list = new ArrayList<>();
		list.add(j1);
		list.add(j2);
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
	
	/**
	 * Currently unused since we aren't enabling database access YET!
	 * 
	 * Returns the interviews for a particular user, by id.
	 * Currently, it also saves some test data into the database, as well as get the test data back,
	 * using a hard-coded id.
	 * 
	 * @param userId The user's id
	 * @return A list of interviews for that user.
	 */
	public ResponseEntity<List<Interview>> getInterviewsFor(Integer userId) {
		//------------------------------
		// Dummy Data
		
		// User bob
		User bob = new User();
		bob.setUserUsername("bob");
		bob.setUserPassword("123");
		userRepo.save(bob);
		
		// Bob's interview
		Interview i1 = new Interview();
		i1.setUser(bob);
		i1.setInterviewMarketer("joe");
		interviewRepo.save(i1);
		
		// Bob's other interview
		Interview i2 = new Interview();
		i2.setUser(bob);
		i2.setInterviewMarketer("joey");
		interviewRepo.save(i2);
		
		// Not Bob's interview
		Interview i3 = new Interview();
		i3.setInterviewMarketer("rainer");
		interviewRepo.save(i3);
		//------------------------------
		// (dummy code ends here)
		
		// IMPORTANT
		// FOR TESTING PURPOSES
		// YOU NEED TO CHECK OUT WHAT ID HIBERNATE GAVE TO BOB
		// SO LIKE, IT MIGHT BE 50, OR 100.  CHECK YOUR SQL DEVELOPER.
		List<Interview> list = interviewRepo.findByUser(userRepo.findOneByUserId(100));
		return new ResponseEntity<>(list, HttpStatus.ACCEPTED);
	}
}
