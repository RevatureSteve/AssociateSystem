package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.TechTopic;

@Repository
public interface TechTopicRepo extends JpaRepository<TechTopic, Integer> {

	TechTopic findByTechTopicName(String name);
}
