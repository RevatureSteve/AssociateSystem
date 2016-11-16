package com.revature.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.revature.pojos.Account;
import com.revature.pojos.Client;
import com.revature.pojos.Job;
import com.revature.pojos.Status;
import com.revature.pojos.User;

public class InterviewDTO implements Serializable {
	
	private static final long serialVersionUID = 7465307080488717710L;
	
	private int interviewId;
	private String interviewMarketer;
	private JobDTO job;
	private Status status; // TODO Create a DTO for this later
	private User user; // TODO Create a DTO for this later
	private Timestamp interviewTime;
	private int interviewRound;
	private String interviewType;
	private String interviewFeedback;
	private int interviewJobNumber;
	
	public InterviewDTO(){}

	public InterviewDTO(int interviewId, String interviewMarketer, JobDTO job, Status status, User user,
			Timestamp interviewTime, int interviewRound, String interviewType, String interviewFeedback, int interviewJobNumber) {
		super();
		this.interviewId = interviewId;
		this.interviewMarketer = interviewMarketer;
		this.job = job;
		this.status = status;
		this.user = user;
		this.interviewTime = interviewTime;
		this.interviewRound = interviewRound;
		this.interviewType = interviewType;
		this.interviewFeedback = interviewFeedback;
		this.interviewJobNumber = interviewJobNumber;
	}

	public int getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(int interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewMarketer() {
		return interviewMarketer;
	}

	public void setInterviewMarketer(String interviewMarketer) {
		this.interviewMarketer = interviewMarketer;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Timestamp interviewTime) {
		this.interviewTime = interviewTime;
	}

	public int getInterviewRound() {
		return interviewRound;
	}

	public void setInterviewRound(int interviewRound) {
		this.interviewRound = interviewRound;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getInterviewType() {
		return interviewType;
	}

	public void setInterviewType(String interviewType) {
		this.interviewType = interviewType;
	}

	public String getInterviewFeedback() {
		return interviewFeedback;
	}

	public void setInterviewFeedback(String intervewFeedback) {
		this.interviewFeedback = intervewFeedback;
	}

	public int getInterviewJobNumber() {
		return interviewJobNumber;
	}

	public void setInterviewJobNumber(int interviewJobNumber) {
		this.interviewJobNumber = interviewJobNumber;
	}

	@Override
	public String toString() {
		return "InterviewDTO [interviewId=" + interviewId + ", interviewMarketer=" + interviewMarketer + ", job=" + job
				+ ", status=" + status + ", user=" + user + ", interviewTime=" + interviewTime + ", interviewRound="
				+ interviewRound + ", interviewType=" + interviewType + ", interviewFeedback=" + interviewFeedback
				+ ", interviewJobNumber=" + interviewJobNumber + "]";
	}
}
