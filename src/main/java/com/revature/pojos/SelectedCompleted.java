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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="selected_completed")
public class SelectedCompleted {

	@Id 
	@SequenceGenerator(name="sc_id_seq", sequenceName="sc_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sc_id_seq")
	@Column(name="sc_id")
	private int selectedCompletedId;

	@Column(name = "sc_time")
	private double selectedCompletedTimeToStartDate;

	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	@ManyToOne
	@JoinColumn(name = "client_id")
	@Fetch(FetchMode.JOIN)
	private Client client;
	
	@Column(name = "sc_timestamp")
	private Timestamp selectedCompletedTimestamp;
	
	public SelectedCompleted(){}

	public SelectedCompleted(double selectedCompletedTimeToStartDate, Account account, Client client,
			Timestamp selectedCompletedTimestamp) {
		super();
		this.selectedCompletedTimeToStartDate = selectedCompletedTimeToStartDate;
		this.account = account;
		this.client = client;
		this.selectedCompletedTimestamp = selectedCompletedTimestamp;
	}

	public int getSelectedCompletedId() {
		return selectedCompletedId;
	}

	public void setSelectedCompletedId(int selectedCompletedId) {
		this.selectedCompletedId = selectedCompletedId;
	}

	public double getSelectedCompletedTimeToStartDate() {
		return selectedCompletedTimeToStartDate;
	}

	public void setSelectedCompletedTimeToStartDate(double selectedCompletedTimeToStartDate) {
		this.selectedCompletedTimeToStartDate = selectedCompletedTimeToStartDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Timestamp getSelectedCompletedTimestamp() {
		return selectedCompletedTimestamp;
	}

	public void setSelectedCompletedTimestamp(Timestamp selectedCompletedTimestamp) {
		this.selectedCompletedTimestamp = selectedCompletedTimestamp;
	}

	@Override
	public String toString() {
		return "SelectedCompleted [selectedCompletedId=" + selectedCompletedId + ", selectedCompletedTimeToStartDate="
				+ selectedCompletedTimeToStartDate + ", account=" + account + ", client=" + client
				+ ", selectedCompletedTimestamp=" + selectedCompletedTimestamp + "]";
	}

}