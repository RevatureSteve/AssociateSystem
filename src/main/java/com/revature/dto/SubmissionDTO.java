package com.revature.dto;

import java.io.Serializable;
import java.sql.Timestamp;

public class SubmissionDTO implements Serializable {
	
	private static final long serialVersionUID = 817275339109350614L;
	
	private int JA_ID;
	private JobDTO job;
	private Timestamp dateSubmitted;
	public SubmissionDTO() {
	}
	public int getJA_ID() {
		return JA_ID;
	}
	public void setJA_ID(int jA_ID) {
		JA_ID = jA_ID;
	}
	public JobDTO getJob() {
		return job;
	}
	public void setJob(JobDTO job) {
		this.job = job;
	}
	public Timestamp getDateSubmitted() {
		return dateSubmitted;
	}
	public void setDateSubmitted(Timestamp dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}
}