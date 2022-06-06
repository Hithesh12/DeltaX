package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.SongRatingServiceDAO;
import com.example.music.DAO.SongServiceDAO;
import com.example.music.model.Song;
import com.example.music.model.SongRating;

@Service("songService")
public class SongServiceImpl implements SongService{
	
	int count = 0;
	int totalRating = 0;
	int average = 0;
	
	@Autowired
	SongServiceDAO songServiceDAO;
	
	@Autowired
	SongRatingServiceDAO songRatingServiceDAO;
	
	@Override
	public List<Song> getAllSongs() {
		songHomeScreen();
		List<Song> songs =songServiceDAO.getAllSongs();
		return songs;
	}

	@Override
	public Song getSong(int id) {
		Song song = songServiceDAO.getSong(id);
		return song;
	}

	@Override
	public Song addSong(Song song) {
		songServiceDAO.addSong(song);
		return song;
	}

	@Override
	public Song updateSong(int id, Song song) {
		songServiceDAO.updateSong(id, song);
		return song;
	}

	@Override
	public void deleteSong(int id) {
		songServiceDAO.deleteSong(id);	
	}

	@Override
	public void updateRating(int id, int rating) {
		songServiceDAO.updateSong(id, rating);
	}

	public void songHomeScreen() {
		List<Song> songs =songServiceDAO.getAllSongs();
		
		for (Song song : songs) {
			List<SongRating> songRatings = songRatingServiceDAO.getAllRatings(song.getSong_id());
			
			for (SongRating rating : songRatings) {
				count++;
				totalRating = totalRating + rating.getRating();
				average = totalRating/count;
			}
			songServiceDAO.updateSong(song.getSong_id(), average);
		}
	}
}
