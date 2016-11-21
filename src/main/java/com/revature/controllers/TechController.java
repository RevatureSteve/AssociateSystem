package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.business.BusinessDelegate;
import com.revature.pojos.TechQuestion;

@RestController
public class TechController {

	@Autowired
	BusinessDelegate business;
	
	@GetMapping("/getQuestions")
	@ResponseBody
	public List<TechQuestion> getQuestions() {
		return business.getQuestions();
	}
	
	@GetMapping("/getQuestionsByTrack")
	@ResponseBody
	public List<TechQuestion> getQuestionsByTrack(@RequestParam("catName") String catName) {
		return business.getQuestionsByTrack(catName);
	}
	
	
}
