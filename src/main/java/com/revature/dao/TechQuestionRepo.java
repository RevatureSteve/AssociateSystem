package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.TechQuestion;
import com.revature.pojos.TechTopic;
import com.revature.pojos.User;

@Repository
public interface TechQuestionRepo extends JpaRepository<TechQuestion, Integer> {

	List<TechQuestion> findByUser(User user);
	List<TechQuestion> findByTechTopics(List<TechTopic> topics);
}
