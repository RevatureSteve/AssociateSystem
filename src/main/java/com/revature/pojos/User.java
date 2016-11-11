package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


/*
 * 
@SequenceGenerator(name="dog_id_seq", sequenceName="dog_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="dog_id_seq")
 */



@Entity
@Table (name="User")
public class User {

	@Id @SequenceGenerator(name="user_id_seq", sequenceName="user_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_id_seq")
	
	
	@Column(name="user_id")
	private int id;

	@Column(name = "user_username")
	private String username;

	@Column(name = "user_password")
	private String password;


	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "role_ID")
	private Role role;
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public User(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}