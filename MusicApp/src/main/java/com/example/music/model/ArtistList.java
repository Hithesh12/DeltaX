package com.example.music.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service   
@Component
public class ArtistList {

	int artist_id;
	String artist_name;	
	String songs;
	
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

	public String getSong() {
		return songs;
	}
	public void setSong(String songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "ArtistList [artist_id=" + artist_id + ", artist_name=" + artist_name + ", songs=" + songs + "]";
	}		
}
