package com.example.music.model;

import java.util.Date;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonFormat;

@Service   
@Component
public class SongList {
	
	int song_id;
	String name;	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date date_of_release;
	int rating;
	String artists;
	
	
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
	
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getArtists() {
		return artists;
	}
	public void setArtists(String artists) {
		this.artists = artists;
	}
	public Date getDate_of_release() {
		return date_of_release;
	}
	public void setDate_of_release(Date date_of_release) {
		this.date_of_release = date_of_release;
	}
	@Override
	public String toString() {
		return "SongList [song_id=" + song_id + ", name=" + name + ", date_of_release=" + date_of_release + ", rating="
				+ rating + ", artists=" + artists + "]";
	}
}
