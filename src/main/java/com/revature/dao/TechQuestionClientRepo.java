package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Client;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.TechQuestionClient;
import com.revature.pojos.TechTopic;
import com.revature.pojos.User;

@Repository
public interface TechQuestionClientRepo extends JpaRepository<TechQuestionClient, Integer> {

	List<TechQuestionClient> findByClient(Client client);
	
}
