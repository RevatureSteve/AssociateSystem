package com.revature.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table (name="interview")
public class Interview {

	@Id 
	@SequenceGenerator(name="interview_id_seq", sequenceName="interview_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="interview_id_seq")
	@Column(name="interview_id")
	private int interviewId;
	
	@Transient
	@Column(name = "interview_marketer")
	private String interviewMarketer;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@OneToOne
	@JoinColumn(name="status_id")
	private Status status;

	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@Column(name = "interview_time")
	private Timestamp interviewTime;
	
	@Column(name = "interview_round")
	private int interviewRound;
	
	public Interview(){}

	public Interview(String interviewMarketer, Client client, Account account, Status status,
			User user, Timestamp interviewTime, int interviewRound) {
		super();
		this.interviewMarketer = interviewMarketer;
		this.client = client;
		this.account = account;
		this.status = status;
		this.user = user;
		this.interviewTime = interviewTime;
		this.interviewRound = interviewRound;
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

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
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

	@Override
	public String toString() {
		return "Interview [interviewId=" + interviewId + ", interviewMarketer=" + interviewMarketer + ", user=" + user
				+ ", interviewTime=" + interviewTime + ", interviewRound=" + interviewRound + "]";
	}

	
	

}