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
	private Timestamp clientAvgStartDate;

	public Client() {}

	public Client(String clientName, Timestamp clientAvgStartDate) {
		super();
		this.clientName = clientName;
		this.clientAvgStartDate = clientAvgStartDate;
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

	public Timestamp getClientAvgStartDate() {
		return clientAvgStartDate;
	}

	public void setClientAvgStartDate(Timestamp clientAvgStartDate) {
		this.clientAvgStartDate = clientAvgStartDate;
	}

	@Override
	public String toString() {
		return "Client [clientId=" + clientId + ", clientName=" + clientName + ", clientAvgStartDate="
				+ clientAvgStartDate + "]";
	}
	

}