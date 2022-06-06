package com.example.music.service;

import java.util.List;

import com.example.music.model.SongRating;

public interface SongRatingService {
	
	public SongRating getRating(int id);

	public List<SongRating> getAllRatings();
	
	public SongRating addRating(SongRating songRating);
	
	public SongRating updateSongRating(int id, SongRating songRating);
	
	public void deleteRating(int id);
}
