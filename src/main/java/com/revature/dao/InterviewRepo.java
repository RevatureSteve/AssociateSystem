package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Interview;
import com.revature.pojos.User;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Integer> {

	List<Interview> findByUser(User findOne);

}
