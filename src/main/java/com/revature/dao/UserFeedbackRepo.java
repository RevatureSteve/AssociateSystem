package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Interview;
import com.revature.pojos.User;
import com.revature.pojos.UserFeedback;

@Repository
public interface UserFeedbackRepo extends JpaRepository<UserFeedback, Integer> {

	List<UserFeedback> findByUser(User user);
	UserFeedback findByInterview(Interview interview);
}
