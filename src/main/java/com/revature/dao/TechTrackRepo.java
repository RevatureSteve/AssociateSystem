package com.revature.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.pojos.TechTrack;

@Repository
public interface TechTrackRepo extends JpaRepository<TechTrack, Integer> {

	TechTrack findByTrackName(String name);
}
