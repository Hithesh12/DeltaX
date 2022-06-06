package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.SongRatingServiceDAO;
import com.example.music.DAO.SongServiceDAO;
import com.example.music.model.SongRating;

@Service("songRatingService")
public class SongRatingServiceImpl implements SongRatingService {
	
	@Autowired
	SongRatingServiceDAO songRatingServiceDAO;
	
	@Autowired
	SongServiceDAO songServiceDAO;
	
	@Override
	public SongRating getRating(int id) {
		SongRating songRating = songRatingServiceDAO.getRating(id);
		return songRating;
	}

	@Override
	public List<SongRating> getAllRatings() {
		List<SongRating> songRating = songRatingServiceDAO.getAllRatings();
		return songRating;
	}

	@Override
	public SongRating addRating(SongRating songRating) {
		songRatingServiceDAO.addRating(songRating);
		return songRating;
	}

	@Override
	public SongRating updateSongRating(int id, SongRating songRating) {
		songRatingServiceDAO.updateSongRating(id, songRating);
		return songRating;
	}

	@Override
	public void deleteRating(int id) {
		songRatingServiceDAO.deleteRating(id);;
	}

	@Override
	public List<SongRating> getAllRatings(int id) {
		List<SongRating> songRating = songRatingServiceDAO.getAllRatings(id);
		return songRating;
	}
	
	
}
