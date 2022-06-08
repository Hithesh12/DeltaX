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
     PRIMARY KEY (`Song_id`)
     );
	 */
	int song_id;
	String name;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date date_of_release;
	
	Blob Image;
	int rating;
	
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
	
	@Override
	public String toString() {
		return "Song [song_id=" + song_id + ", name=" + name + ", date_of_release=" + date_of_release + ", Image="
				+ Image + ", rating=" + rating + "]";
	}
	
	
}
