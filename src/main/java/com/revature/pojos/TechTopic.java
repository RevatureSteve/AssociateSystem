package com.revature.pojos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tech_topic")
public class TechTopic {

	@Id 
	@SequenceGenerator(name="tech_topic_id_seq", sequenceName="tech_topic_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tech_topic_id_seq")
	@Column(name = "tech_topic_id")
	private int techTopicId;

	@Column(name = "tech_topic_name")
	private String techTopicName;
	
	public TechTopic() {}

	public TechTopic(String techTopicName) {
		super();
		this.techTopicName = techTopicName;
	}

	public int getTechTopicId() {
		return techTopicId;
	}

	public void setTechTopicId(int techTopicId) {
		this.techTopicId = techTopicId;
	}

	public String getTechTopicName() {
		return techTopicName;
	}

	public void setTechTopicName(String techTopicName) {
		this.techTopicName = techTopicName;
	}

	@Override
	public String toString() {
		return "TechTopic [techTopicId=" + techTopicId + ", techTopicName=" + techTopicName + "]";
	}

	
}
