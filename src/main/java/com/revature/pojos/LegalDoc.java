package com.revature.pojos;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table (name="status")
public class LegalDoc {

	@Id 
	@SequenceGenerator(name="legal_doc_id_seq", sequenceName="legal_doc_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="legal_doc_id_seq")
	@Column(name="legal_doc_id")
	private int legalDocId;

	@Column(name = "legal_doc_name")
	private String legalDocName;

	public LegalDoc() {}

	public LegalDoc(String legalDocName) {
		super();
		this.legalDocName = legalDocName;
	}

	public int getLegalDocId() {
		return legalDocId;
	}

	public void setLegalDocId(int legalDocId) {
		this.legalDocId = legalDocId;
	}

	public String getLegalDocName() {
		return legalDocName;
	}

	public void setLegalDocName(String legalDocName) {
		this.legalDocName = legalDocName;
	}

	@Override
	public String toString() {
		return "LegalDoc [legalDocId=" + legalDocId + ", legalDocName=" + legalDocName + "]";
	}
	
	

}