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

@Entity
@Table(name="tech_question_client")
public class TechQuestionClient {

	@Id 
	@SequenceGenerator(name="tech_question_client_id_seq", sequenceName="tech_question_client_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tech_question_client_id_seq")
	@Column(name = "tech_question_client_id")
	private int techQuestionClientId;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;
	
	@Column(name = "tech_question_client_timestamp")
	private Timestamp techQuestionClientTimestamp;

	public TechQuestionClient() {}

	public TechQuestionClient(Client client, Timestamp techQuestionClientTimestamp) {
		super();
		this.client = client;
		this.techQuestionClientTimestamp = techQuestionClientTimestamp;
	}

	public int getTechQuestionClientId() {
		return techQuestionClientId;
	}

	public void setTechQuestionClientId(int techQuestionClientId) {
		this.techQuestionClientId = techQuestionClientId;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Timestamp getTechQuestionClientTimestamp() {
		return techQuestionClientTimestamp;
	}

	public void setTechQuestionClientTimestamp(Timestamp techQuestionClientTimestamp) {
		this.techQuestionClientTimestamp = techQuestionClientTimestamp;
	}

	@Override
	public String toString() {
		return "TechQuestionClient [techQuestionClientId=" + techQuestionClientId + ", client=" + client + "]";
	}

	
}
