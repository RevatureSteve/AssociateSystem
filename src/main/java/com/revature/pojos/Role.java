package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role {

	@Id @SequenceGenerator(name="role_id_seq", sequenceName="role_id_seq") @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_id_seq")
	@Column(name = "role_ID")
	private int role_id;

	@Column(name = "role_name")
	private String role_name;

	public Role(int role, String role_name) {
		super();
		this.role_name = role_name;
	}

	public String getRole_name() {
		return role_name;
	}

	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}


}
