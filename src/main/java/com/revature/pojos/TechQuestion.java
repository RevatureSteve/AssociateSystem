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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="tech_question")
public class TechQuestion {

	@Id 
	@SequenceGenerator(name="tech_question_id_seq", sequenceName="tech_question_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tech_question_id_seq")
	@Column(name = "tech_question_id")
	private int techQuestionId;

	@Column(name = "tech_question_name")
	private String techQuestionName;
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToMany
	@JoinColumn(name = "tech_topic_id")
	private List<TechTopic> techTopics;

	public TechQuestion() {}

	public TechQuestion(String techQuestionName, User user, List<TechTopic> techTopics) {
		super();
		this.techQuestionName = techQuestionName;
		this.user = user;
		this.techTopics = techTopics;
	}

	public int getTechQuestionId() {
		return techQuestionId;
	}

	public void setTechQuestionId(int techQuestionId) {
		this.techQuestionId = techQuestionId;
	}

	public String getTechQuestionName() {
		return techQuestionName;
	}

	public void setTechQuestionName(String techQuestionName) {
		this.techQuestionName = techQuestionName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<TechTopic> getTechTopics() {
		return techTopics;
	}

	public void setTechTopics(List<TechTopic> techTopics) {
		this.techTopics = techTopics;
	}

	@Override
	public String toString() {
		return "TechQuestion [techQuestionId=" + techQuestionId + ", techQuestionName=" + techQuestionName + ", user="
				+ user + "]";
	}
	
}
