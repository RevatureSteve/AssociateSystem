package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Integer> {

	Client findByClientName(String name);
}
