package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.LegalDoc;

@Repository
public interface LegalDocRepo extends JpaRepository<LegalDoc, Integer> {

	
}
