package com.revature.dto;

import java.io.Serializable;
import java.sql.Timestamp;

import com.revature.pojos.Account;
import com.revature.pojos.Client;

public class JobDTO implements Serializable {
	
	private static final long serialVersionUID = 7465307080488717710L;
	
	private int jobId;
	private Client client; // TODO Create a DTO for this later
	private Account account; // TODO Create a DTO for this later
	private double jobContractLength;
	private String jobCity;
	private String jobState;
	private Timestamp jobTimestamp;
	private String jobTitle;
	
	public JobDTO(){}

	public JobDTO(int jobId, Client client, Account account, double jobContractLength, String jobCity,
			String jobState, Timestamp jobTimestamp, String jobTitle) {
		super();
		this.jobId = jobId;
		this.client = client;
		this.account = account;
		this.jobContractLength = jobContractLength;
		this.jobCity = jobCity;
		this.jobState = jobState;
		this.jobTimestamp = jobTimestamp;
		this.jobTitle = jobTitle;
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

	public String getJobCity() {
		return jobCity;
	}

	public void setJobCity(String jobCity) {
		this.jobCity = jobCity;
	}

	public String getJobState() {
		return jobState;
	}

	public void setJobState(String jobState) {
		this.jobState = jobState;
	}

	@SuppressWarnings("deprecation")
	public String getJobTimestamp() {
		String str = jobTimestamp.toString();
		String suffix = " AM";
		if (jobTimestamp.getHours() >= 12) {
			suffix = " PM";
			if (jobTimestamp.getHours() > 12) {
				jobTimestamp.setHours(jobTimestamp.getHours() - 12);
				str = jobTimestamp.toString();
				jobTimestamp.setHours(jobTimestamp.getHours() + 12);
			}
		}
		return str.substring(0, str.lastIndexOf(":")) + suffix;
	}

	public void setJobTimestamp(Timestamp jobTimestamp) {
		this.jobTimestamp = jobTimestamp;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	@Override
	public String toString() {
		return "JobDTO [jobId=" + jobId + ", client=" + client + ", account=" + account + ", jobContractLength="
				+ jobContractLength + ", jobCity=" + jobCity + ", jobState=" + jobState + ", jobTimestamp="
				+ jobTimestamp + ", jobTitle=" + jobTitle + "]";
	}
	
}
