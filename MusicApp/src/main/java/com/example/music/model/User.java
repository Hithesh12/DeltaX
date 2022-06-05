package com.example.music.model;


import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service   
@Component 
public class User{
	
	/*
	 * CREATE TABLE `User` (
	  `User_id` int(11) NOT NULL AUTO_INCREMENT,
	  `Name` varchar(25) NOT NULL,
	  `User_email` varchar(50) NOT NULL,
	  `Password` varchar(20) NOT NULL,
	  `Date_of_birth` date NOT NULL,
	  `Security_question` varchar(50) NOT NULL,
	  `Security_answer` varchar(50) NOT NULL,
	  PRIMARY KEY (`User_id`)
		);
	 */
	int user_id;
	String name;
	String user_email;
	String password;
	Date date_of_birth;
	String security_question;
	String security_answer;
	
	public User() {
		super();
	}

	public User(int user_id, String name, String user_email, String password, Date date_of_birth, String security_question, String security_answer) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.user_email = user_email;
		this.password = password;
		this.date_of_birth = date_of_birth;
		this.security_question = security_question;
		this.security_answer = security_answer;
				
	}

	public int getUserId() {
		return user_id;
	}

	public void setUserId(int user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getUserEmail() {
		return user_email;
	}
	
	public void setUserEmail(String user_email) {
		this.user_email = user_email;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Date getDateOfBirth() {
		return date_of_birth;
	}
	
	public void setDateOfBirth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	
	public String getSecurityQuestion() {
		return security_question;
	}
	
	public void setSecurityQuestion(String security_question) {
		this.security_question = security_question;
	}
	
	public String getSecurityAnswer() {
		return security_answer;
	}
	
	public void setSecurityAnswer(String security_answer) {
		this.security_answer = security_answer;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", name=" + name + ", user_email=" + user_email + ", password=" + password
				+ ", date_of_birth=" + date_of_birth + ", security_question=" + security_question + ", security_answer="
				+ security_answer + "]";
	}

	
}
