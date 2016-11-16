package com.revature.pojos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="client_account_doc")
public class ClientAccountDoc {

	@Id 
	@SequenceGenerator(name="cad_id_seq", sequenceName="cad_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="cad_id_seq")
	@Column(name="cad_id")
	private int clientAccountDocId;

	@ManyToMany
	@JoinColumn(name = "user_id")
	private List<User> users;

	@ManyToOne
	@JoinColumn(name="client_id")
	private Client client;

	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@OneToOne
	@JoinColumn(name="legal_doc_id")
	private LegalDoc legalDoc;

	public ClientAccountDoc(){}

	public ClientAccountDoc(List<User> users, Client client, Account account, LegalDoc legalDoc) {
		super();
		this.users = users;
		this.client = client;
		this.account = account;
		this.legalDoc = legalDoc;
	}

	public int getClientAccountDocId() {
		return clientAccountDocId;
	}

	public void setClientAccountDocId(int clientAccountDocId) {
		this.clientAccountDocId = clientAccountDocId;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
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

	public LegalDoc getLegalDoc() {
		return legalDoc;
	}

	public void setLegalDoc(LegalDoc legalDoc) {
		this.legalDoc = legalDoc;
	}

	@Override
	public String toString() {
		return "ClientAccountDoc [clientAccountDocId=" + clientAccountDocId + ", users=" + users + ", client=" + client
				+ ", account=" + account + ", legalDoc=" + legalDoc + "]";
	}

	
	
}