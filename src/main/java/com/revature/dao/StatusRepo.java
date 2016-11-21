package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pojos.Status;

public interface StatusRepo extends JpaRepository<Status, Integer> {

	
}
