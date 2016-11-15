package com.revature.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {

	@Id 
	@SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	@Column(name="user_id")
	private int userId;

	@Column(name = "user_username")
	private String userUsername;

	@Column(name = "user_password")
	private String userPassword;

	@ManyToOne
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToOne
	@JoinColumn(name = "track_id")
	private TechTrack track;
	
	@ManyToMany
	@JoinColumn(name = "job_id")
	private List<Job> jobs;
	
	public User(){}

	public User(String username, String password, Role role, TechTrack track, List<Job> jobs) {
		super();
		this.userUsername = username;
		this.userPassword = password;
		this.role = role;
		this.track = track;
		this.jobs = jobs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public TechTrack getTrack() {
		return track;
	}

	public void setTrack(TechTrack track) {
		this.track = track;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userPassword=" + userPassword
				+ ", role=" + role + ", track=" + track + ", jobs=" + jobs + "]";
	}


	

}