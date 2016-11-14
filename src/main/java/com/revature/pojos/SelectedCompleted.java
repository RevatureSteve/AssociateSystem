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

@Entity
@Table (name="selected_completed")
public class SelectedCompleted {

	@Id 
	@SequenceGenerator(name="selected_completed_id_seq", sequenceName="selected_completed_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="selected_completed_id_seq")
	@Column(name="selected_completed_id")
	private int selectedCompletedId;

	@Column(name = "selected_completed_time_to_start_date")
	private double selectedCompletedTimeToStartDate;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@OneToOne
	@JoinColumn(name = "selected_completed_timestamp")
	private Timestamp selectedCompletedTimestamp;
	
	public SelectedCompleted(){}

	public SelectedCompleted(double selectedCompletedTimeToStartDate, Client client,
			Timestamp selectedCompletedTimestamp) {
		super();
		this.selectedCompletedTimeToStartDate = selectedCompletedTimeToStartDate;
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
				+ selectedCompletedTimeToStartDate + ", client=" + client + "]";
	}


}