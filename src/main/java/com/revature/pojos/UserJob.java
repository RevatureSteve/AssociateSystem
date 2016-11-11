package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "UserJob")
public class UserJob {

	
	@Id 
	@SequenceGenerator(name="userjob_id_seq", sequenceName="userjob_id_seq") 
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="userjob_id_seq")
	@Column(name="userjob_id")
	private int userjob_id;
	
	//foreign key user_id to userjob
	// if userjob is a connected between users and jobs, a user may be submitted to multiple users and a job may have many users. Thus the relation is a manytomany one
	
	@ManyToMany
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToMany
	@JoinColumn(name = "job_id")
	private Job job; //use this name when creating Job table (to be consistent)

	public UserJob(User user, Job job) {
		super();
		this.user = user;
		this.job = job;
	}

	public int getUserjob_id() {
		return userjob_id;
	}

	public void setUserjob_id(int userjob_id) {
		this.userjob_id = userjob_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}
	
	
	
	
	
	
}
