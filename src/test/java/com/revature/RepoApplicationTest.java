package com.revature;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.dao.AccountRepo;
import com.revature.pojos.Account;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoApplicationTest {

	@Autowired
	AccountRepo accountRepo;
	
	
	public void makeAccountRepo() {
		Account account = new Account("Walmart");
		accountRepo.save(account);
		System.out.println("Account made");
	}

}
