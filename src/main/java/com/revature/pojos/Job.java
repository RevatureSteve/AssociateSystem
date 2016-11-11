package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Job")
public class Job {

	@Id 
	@SequenceGenerator(name = "job_id_seq", sequenceName="job_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="job_id_seq")
	@Column(name="job_id")
	private int job_id;
	
	


}
