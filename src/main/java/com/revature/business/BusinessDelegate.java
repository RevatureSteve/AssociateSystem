package com.revature.business;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.dto.AuthenticationDTO;
import com.revature.dto.InterviewDTO;
import com.revature.dto.JobDTO;
import com.revature.pojos.Interview;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.User;

public interface BusinessDelegate {
	
	public ResponseEntity<List<InterviewDTO>> dummyInterviews();
	public ResponseEntity<List<JobDTO>> dummyJobs();
	public ResponseEntity<List<Interview>> getInterviewsFor(int userId);
	
	public ResponseEntity<User> authenticate(AuthenticationDTO auth);
	
	public List<TechQuestion> getQuestions();
	
	/**
	 * <h1>Get all Questions By Track</h1>
	 * 
	 * @param String
	 * @return A List of TechQuestion
	 * @author Steve Kelsey
	 */
	public List<TechQuestion> getQuestionsByTrack(@RequestParam("catName") String catName);
}
