package com.example.music.DAO;

import java.util.List;

import com.example.music.model.SongRating;

public interface SongRatingServiceDAO {
	
	SongRating getRating(int id);

	List<SongRating> getAllRatings();
	
	public SongRating addRating(SongRating songRating);
	
	public SongRating updateSongRating(int id, SongRating songRating);
	
	public void deleteRating(int id);
	
	
}
