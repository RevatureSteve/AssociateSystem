package com.revature;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.revature.dao.AccountRepo;
import com.revature.dao.ClientRepo;
import com.revature.dao.InterviewRepo;
import com.revature.dao.JobRepo;
import com.revature.dao.RoleRepo;
import com.revature.dao.SelectedCompletedRepo;
import com.revature.dao.StatusRepo;
import com.revature.dao.TechQuestionRepo;
import com.revature.dao.TechTrackRepo;
import com.revature.dao.UserFeedbackRepo;
import com.revature.dao.UserRepo;
import com.revature.pojos.Account;
import com.revature.pojos.Client;
import com.revature.pojos.Interview;
import com.revature.pojos.Job;
import com.revature.pojos.Role;
import com.revature.pojos.SelectedCompleted;
import com.revature.pojos.Status;
import com.revature.pojos.TechQuestion;
import com.revature.pojos.TechTrack;
import com.revature.pojos.User;
import com.revature.pojos.UserFeedback;

import ch.qos.logback.classic.net.SyslogAppender;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RepoApplicationTest {

	
	@Autowired
	AccountRepo accountRepo;
	
	@Autowired
	ClientRepo clientRepo;
	
	@Autowired
	StatusRepo statusRepo;
	
	@Autowired
	RoleRepo roleRepo;
	
	@Autowired
	JobRepo jobRepo;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	TechTrackRepo techTrackRepo;
	
	@Autowired
	InterviewRepo interviewRepo;
	
	@Autowired
	SelectedCompletedRepo selectedCompletedRepo;
	
	@Autowired
	UserFeedbackRepo userFeedbackRepo;
	
	@Autowired
	TechQuestionRepo techQuestionRepo;
	
	Account account;
	Client client;
	Interview interview;
	Status status;
	User user;
	Role role;
	TechTrack techTrack;
	Job job;
	SelectedCompleted selectedCompleted;
	UserFeedback userFeedback;
	TechQuestion techQuestion;
	
	public void makeAccountRepo() {
		account = new Account("Apex Group");
		accountRepo.save(account);
		System.out.println("Account made");
	}
	
	public void makeClient() {
		client = new Client("Walmart", 12, 30);
		clientRepo.save(client);
		System.out.println("Client made");
	}
	
	public void makeStatus() {
		status = new Status("In Progress");
		statusRepo.save(status);
		System.out.println("Status made");
	}
	
	public void makeRole() {
		role = new Role("User");
		roleRepo.save(role);
		System.out.println("Role made");
	}
	
	public void makeTechTrack() {
		techTrack = new TechTrack("Java");
		techTrackRepo.save(techTrack);
		System.out.println("Tech Track made");
	}
	
	public void makeUserFeedBack() {
		User userResult = userRepo.findOneByUserId(100);
		System.out.println(userResult.toString());
		List<Interview> interviewResults = interviewRepo.findByUser(userResult);
		interviewResults.forEach(i -> {
			userFeedback = new UserFeedback("12", 3, i.getUser(), i);
			userFeedbackRepo.save(userFeedback);
		});
		
	}
	
	public void makeJob() {
		List<User> users = new ArrayList<>();
	//	job = new Job(client, account, 10,users);
		jobRepo.save(job);
		System.out.println("Job made");
	}
	
	
	public void makeUser() {
		List<Job> jobs = new ArrayList<>();
		jobs.add(job);
		user = new User("BigPapa", "toocoool4u", role, techTrack, jobs);
		userRepo.save(user);
		System.out.println("User made");
	}
	
	public void makeInterview() {
		
	//	interview = new Interview("Jon", client, account, status, user, new Timestamp(22222), 1);
		interviewRepo.save(interview);
		System.out.println("Interview made");
	}
	
	public void makeSelectedCompleted() {
	//	selectedCompleted = new SelectedCompleted(22, client, new Timestamp(23432));
		selectedCompletedRepo.save(selectedCompleted);
		System.out.println("Selected Completed Made");
	}
	
	@Test
	public void testCreateRepos() {
		makeClient();
		makeAccountRepo();
		makeStatus();
		makeRole();
		makeTechTrack();
		//makeJob();
		makeUser();
		//makeInterview();
	}
	
//	@Test
//	public void getAccount() {
//		Account accountResult = accountRepo.findByAccountName("Apex Group");
//		System.out.println(accountResult.toString());
//	}
	
//	@Test
//	public void getInterview() {
//		User userResult = userRepo.findOneByUserId(100);
//		System.out.println(userResult.toString());
//		List<Interview> interviewResults = interviewRepo.findByUser(userResult);
//		
//		interviewResults.forEach(i -> System.out.println(i.toString()));
//		
//	}
	
	@Test
	public void getJob() {
		List<Job> jobs = jobRepo.findAll();
		
		jobs.forEach(j -> System.out.println(j.toString()));
	}
	
//	@Test
//	public void getFeedback() {
//	//	makeUserFeedBack();
//		User userResult = userRepo.findOneByUserId(100);
//		System.out.println(userResult.toString());
//		List<Interview> interviewResults = interviewRepo.findByUser(userResult);
//		System.out.println(userFeedbackRepo.findByInterview(interviewResults.get(0)));
//		
//	}
	
	
	@Test
	public void getSelectedCompleted() {
		//makeSelectedCompleted();
		List<SelectedCompleted> selectedCompleteds = selectedCompletedRepo.findAll();
		selectedCompleteds.forEach(s -> System.out.println(s.toString()));
	}
	

}
