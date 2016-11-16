package com.revature.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Client;
import com.revature.pojos.SelectedCompleted;

@Repository
public interface SelectedCompletedRepo extends JpaRepository<SelectedCompleted, Integer> {

	List<SelectedCompleted> findByClient(Client client);
}
