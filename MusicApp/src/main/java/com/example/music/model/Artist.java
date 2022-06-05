package com.example.music.model;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service   
@Component
public class Artist {

	/*
	 * CREATE TABLE `Artist` (
  	   `Artist_id` int(11) NOT NULL AUTO_INCREMENT,
       `Artist_name` varchar(25) NOT NULL,
       `Date_of_birth` date NOT NULL,
       `Bio` varchar(250) NOT NULL,
       `User_id` int(11),
       PRIMARY KEY (`Artist_id`),
       FOREIGN KEY (`User_id`) REFERENCES User(`User_id`)
       );
	 */
	
	int artist_id;
	String artist_name;
	Date date_of_birth;
	String bio;
	int user_id;
	
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	public String getArtist_name() {
		return artist_name;
	}
	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}
	public Date getDate_of_birth() {
		return date_of_birth;
	}
	public void setDate_of_birth(Date date_of_birth) {
		this.date_of_birth = date_of_birth;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	@Override
	public String toString() {
		return "Artist [artist_id=" + artist_id + ", artist_name=" + artist_name + ", date_of_birth=" + date_of_birth
				+ ", bio=" + bio + ", user_id=" + user_id + "]";
	}
		
}
