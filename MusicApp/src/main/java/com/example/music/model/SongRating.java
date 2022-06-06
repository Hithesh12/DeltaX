package com.example.music.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service   
@Component
public class SongRating {

	/*
	 * CREATE TABLE `Song_Rating` (
     `Rating_id` int(11) NOT NULL AUTO_INCREMENT,
     `Rating` int(5) NOT NULL,  
     `Song_id` int(11),
     PRIMARY KEY (`Rating_id`),
     FOREIGN KEY (`Song_id`) REFERENCES Song(`Song_id`)
     );
	 */
	
	int rating_id;
	int rating;	
	int song_id;
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getSong_id() {
		return song_id;
	}
	public void setSong_id(int song_id) {
		this.song_id = song_id;
	}
	@Override
	public String toString() {
		return "SongRating [rating_id=" + rating_id + ", rating=" + rating + ", song_id=" + song_id + "]";
	}
	
	
}
