package com.example.music.DAO;

import java.util.List;

import com.example.music.model.SongRating;

public interface SongRatingServiceDAO {
	
	public SongRating getRating(int id);

	public List<SongRating> getAllRatings();
	
	public SongRating addRating(SongRating songRating);
	
	public SongRating updateSongRating(int id, SongRating songRating);
	
	public void deleteRating(int id);
	
	public List<SongRating> getAllRatings(int id);

}
