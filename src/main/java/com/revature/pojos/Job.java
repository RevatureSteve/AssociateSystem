package com.revature.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.FetchMode;
import org.hibernate.annotations.Fetch;

@Entity
@Table(name="job")
public class Job {

	@Id 
	@SequenceGenerator(name = "job_id_seq", sequenceName="job_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="job_id_seq")
	@Column(name="job_id")
	private int jobId;
	
	@ManyToOne
	@JoinColumn(name="client_id")
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private Client client;

	@ManyToOne
	@JoinColumn(name="account_id")
	@Fetch(org.hibernate.annotations.FetchMode.JOIN)
	private Account account;
	
	@Column(name="job_contract_length")
	private double jobContractLength;
	
//	@ManyToMany(mappedBy="jobs", cascade=CascadeType.ALL)
//	@Fetch(FetchMode.JOIN)
//	private List<User> users;
	
	public Job() {}

	public Job(Client client, Account account, double jobContractLength) {
		super();
		this.client = client;
		this.account = account;
		this.jobContractLength = jobContractLength;
	}

	public int getJobId() {
		return jobId;
	}

	public void setJobId(int jobId) {
		this.jobId = jobId;
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

	public double getJobContractLength() {
		return jobContractLength;
	}

	public void setJobContractLength(double jobContractLength) {
		this.jobContractLength = jobContractLength;
	}

	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", client=" + client + ", account=" + account + ", jobContractLength="
				+ jobContractLength + "]";
	}

}
