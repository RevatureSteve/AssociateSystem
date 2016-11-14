package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {

	@Id 
	@SequenceGenerator(name="role_id_seq", sequenceName="role_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="role_id_seq")
	@Column(name = "role_id")
	private int roleId;

	@Column(name = "role_name")
	private String roleName;

	public Role() {}
	
	public Role(String role_name) {
		this.roleName = role_name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + "]";
	}

	

}
