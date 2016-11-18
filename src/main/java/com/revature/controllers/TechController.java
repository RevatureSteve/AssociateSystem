package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.dao.TechQuestionRepo;
import com.revature.pojos.Job;
import com.revature.pojos.Role;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.TechTopic;
import com.revature.pojos.TechTrack;
import com.revature.pojos.User;

@RestController
public class TechController {

	@Autowired
	TechQuestionRepo techQuestionRepo;
	
	@Autowired
	
	
	@GetMapping("/getQuestions")
	@ResponseBody
	public List<TechQuestion> getQuestions() {
		//List<TechQuestion> questions = techQuestionRepo.findAll();
		List<Job> jobs = new ArrayList<>(); 
		User user = new User("James", "123244", new Role("User"), new TechTrack("Java"), jobs);
		List<TechTopic> topics = new ArrayList<>();
		topics.add(new TechTopic("Java"));
		TechQuestion tech = new TechQuestion("Whats good", user, topics);
		
		
		 
		User user2 = new User("Yindel", "123244", new Role("User"), new TechTrack("Java"), jobs);
		TechQuestion tech2 = new TechQuestion("我病了", user2, topics);
		
		List<TechQuestion> questions = new ArrayList<TechQuestion>();
		questions.add(tech);
		questions.add(tech2);
		techQuestionRepo.save(tech);
		techQuestionRepo.save(tech2);
		return questions;
	}
	
	@GetMapping("/getQuestionsByTrack")
	@ResponseBody
	public List<TechQuestion> getQuestionsByTrack(@RequestParam("catName") String catName) {
		
		
		
		return null;
	}
	
	
}
