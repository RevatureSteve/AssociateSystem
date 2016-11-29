package com.revature.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.revature.dao.TechQuestionRepo;
import com.revature.pojos.Job;
import com.revature.pojos.Role;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.TechTopic;
import com.revature.pojos.TechTrack;
import com.revature.pojos.User;

@Service
public class QuestionBankService {

	@Autowired
	TechQuestionRepo techQuestionRepo;
	
	/**
	 * For now, this adds dummy data to the database and returns it.
	 * @return A list of TechQuestions
	 */
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
	
	/**
	 * TODO
	 * <h1>Get all Questions By Track</h1>
	 * 
	 * @param String catName
	 * @return List<TechQuestion>
	 */
	public List<TechQuestion> getQuestionsByTrack(@RequestParam("catName") String catName) {
		return null;
	}
}
