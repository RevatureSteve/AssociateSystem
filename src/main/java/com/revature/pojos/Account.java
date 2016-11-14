package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="account")
public class Account {

	@Id 
	@SequenceGenerator(name="account_id_seq", sequenceName="account_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_id_seq")
	@Column(name="account_id")
	private int accountId;

	@Column(name = "account_name")
	private String accountName;

	public Account() {}

	public Account(String accountName) {
		super();
		this.accountName = accountName;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + "]";
	}
	

}