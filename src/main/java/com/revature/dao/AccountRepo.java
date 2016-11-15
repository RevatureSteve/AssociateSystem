package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Integer> {
	
	Account findByAccountName(String name);

}
