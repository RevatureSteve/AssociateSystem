package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.pojos.Job;

public interface JobRepo extends JpaRepository<Job, Integer> {

}
