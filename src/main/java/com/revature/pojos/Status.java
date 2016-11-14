package com.revature.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="status")
public class Status {

	@Id 
	@SequenceGenerator(name="status_id_seq", sequenceName="status_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_id_seq")
	@Column(name="status_id")
	private int statusId;

	@Column(name = "status_name")
	private String statusName;

	public Status() {}

	public Status(String statusName) {
		super();
		this.statusName = statusName;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusName() {
		return statusName;
	}

	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	@Override
	public String toString() {
		return "Status [statusId=" + statusId + ", statusName=" + statusName + "]";
	}


}