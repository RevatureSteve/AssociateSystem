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
@Table (name="user_feedback")
public class UserFeedback {

	@Id 
	@SequenceGenerator(name="user_feedback_id_seq", sequenceName="user_feedback_id_seq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="user_feedback_id_seq")
	@Column(name="user_feedback_id")
	private int userFeedbackId;

	@Column(name = "user_feedback_interview_length")
	private String userFeedbackInterviewLength;

	@Column(name = "user_feedback_difficulty")
	private int userFeedbackDifficulty;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne
	@JoinColumn(name = "interview_id")
	private Interview interview;
	
	public UserFeedback(){}

	public UserFeedback(String interviewLength, int difficulty, User user, Interview interview) {
		super();
		this.userFeedbackInterviewLength = interviewLength;
		this.userFeedbackDifficulty = difficulty;
		this.user = user;
		this.interview = interview;
	}

	public int getUserFeedbackId() {
		return userFeedbackId;
	}

	public void setUserFeedbackId(int userFeedbackId) {
		this.userFeedbackId = userFeedbackId;
	}

	public String getUserFeedbackInterviewLength() {
		return userFeedbackInterviewLength;
	}

	public void setUserFeedbackInterviewLength(String userFeedbackInterviewLength) {
		this.userFeedbackInterviewLength = userFeedbackInterviewLength;
	}

	public int getUserFeedbackDifficulty() {
		return userFeedbackDifficulty;
	}

	public void setUserFeedbackDifficulty(int userFeedbackDifficulty) {
		this.userFeedbackDifficulty = userFeedbackDifficulty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Interview getInterview() {
		return interview;
	}

	public void setInterview(Interview interview) {
		this.interview = interview;
	}

	@Override
	public String toString() {
		return "UserFeedback [userFeedbackId=" + userFeedbackId + ", userFeedbackInterviewLength="
				+ userFeedbackInterviewLength + ", userFeedbackDifficulty=" + userFeedbackDifficulty + ", user=" + user
				+ ", interview=" + interview + "]";
	}

	
	

}