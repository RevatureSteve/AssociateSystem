package com.revature.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.dto.AuthenticationDTO;
import com.revature.dto.InterviewDTO;
import com.revature.dto.JobDTO;
import com.revature.pojos.Interview;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.User;
import com.revature.service.AuthenticationService;
import com.revature.service.QuestionBankService;
import com.revature.service.TestService;

@Service
public class BusinessDelegateImpl implements BusinessDelegate {
	
	@Autowired
	TestService testService;
	
	@Autowired
	AuthenticationService authenticationService;

	@Autowired
	QuestionBankService questionBankService;
	
	public ResponseEntity<List<InterviewDTO>> dummyInterviews() {
		return testService.dummyInterviews();
	}
	
	public ResponseEntity<List<JobDTO>> dummyJobs() {
		return testService.dummyJobs();
	}
	
	public ResponseEntity<List<Interview>> getInterviewsFor(int userId) {
		return testService.getInterviewsFor(userId);
	}
	
	public ResponseEntity<User> authenticate(AuthenticationDTO auth) {
		return authenticationService.authenticate(auth);
	}
	
	public List<TechQuestion> getQuestions() {
		return questionBankService.getQuestions();
	}
	
	public List<TechQuestion> getQuestionsByTrack(@RequestParam("catName") String catName) {
		return questionBankService.getQuestionsByTrack(catName);
	}
}
