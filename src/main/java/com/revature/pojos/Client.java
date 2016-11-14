package com.revature.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="client")
public class Client {

	@Id 
	@SequenceGenerator(name="client_id_seq", sequenceName="client_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="client_id_seq")
	@Column(name="client_id")
	private int clientId;

	@Column(name = "client_name")
	private String clientName;
	
	@Column(name = "client_avg_start_date")
	private double clientAvgStartDate;
	
	@Column(name = "client_avg_interview_length")
	private double clientAvgInterviewLength;

	public Client() {}

	public Client(String clientName, double clientAvgStartDate, double clientAvgInterviewLength) {
		super();
		this.clientName = clientName;
		this.clientAvgStartDate = clientAvgStartDate;
		this.clientAvgInterviewLength = clientAvgInterviewLength;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	public double getClientAvgStartDate() {
		return clientAvgStartDate;
	}

	public void setClientAvgStartDate(double clientAvgStartDate) {
		this.clientAvgStartDate = clientAvgStartDate;
	}

	public double getClientAvgInterviewLength() {
		return clientAvgInterviewLength;
	}

	public void setClientAvgInterviewLength(double clientAvgInterviewLength) {
		this.clientAvgInterviewLength = clientAvgInterviewLength;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientAvgStartDate="
				+ clientAvgStartDate + ", clientAvgInterviewLength=" + clientAvgInterviewLength + "]";
	}

	

}