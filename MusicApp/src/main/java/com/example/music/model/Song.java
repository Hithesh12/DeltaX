package com.example.music.model;

import java.sql.Blob;
import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

@Service   
@Component
public class Song {
	/*
	 * CREATE TABLE `Song` (
     `Song_id` int(11) NOT NULL AUTO_INCREMENT,
     `name` varchar(25) NOT NULL,
     `Date_of_release` date NOT NULL,
     `Image` blob,
     `Rating` int(5) NOT NULL,  
     `User_id` int(11),
     `Artist_id` int(11),
     PRIMARY KEY (`Song_id`),
     FOREIGN KEY (`User_id`) REFERENCES User(`User_id`),
     FOREIGN KEY (`Artist_id`) REFERENCES Artist(`Artist_id`)
     );
	 */
	int song_id;
	String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date date_of_release;
	
	Blob Image;
	int rating;
	int user_id;
	int artist_id;
	
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate_of_release() {
		return date_of_release;
	}
	public void setDate_of_release(Date date_of_release) {
		this.date_of_release = date_of_release;
	}
	public Blob getImage() {
		return Image;
	}
	public void setImage(Blob image) {
		Image = image;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getArtist_id() {
		return artist_id;
	}
	public void setArtist_id(int artist_id) {
		this.artist_id = artist_id;
	}
	@Override
	public String toString() {
		return "Song [song_id=" + song_id + ", name=" + name + ", date_of_release=" + date_of_release + ", Image="
				+ Image + ", rating=" + rating + ", user_id=" + user_id + ", artist_id=" + artist_id + "]";
	}
	
	
}
