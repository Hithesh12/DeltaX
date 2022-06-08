package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.SongRatingServiceDAO;
import com.example.music.DAO.SongServiceDAO;
import com.example.music.model.Song;
import com.example.music.model.SongList;
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
		averageRating();
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

	public void averageRating() {
		List<Song> songs =songServiceDAO.getAllSongs();
		System.out.println(songs.toString());
		for (Song song : songs) {
			//System.out.println(song.getSong_id()); 
			
			List<SongRating> songRatings = songRatingServiceDAO.getAllRatings(song.getSong_id());
			//System.out.println(songRatings.toString());
			
			for (SongRating rating : songRatings) {
				count++;
				totalRating = totalRating + rating.getRating();
				average = totalRating/count;
			}
			totalRating=0;
			count=0;
			songServiceDAO.updateSong(song.getSong_id(), average);
		}
	}

	@Override
	public List<SongList> getSongList() {
		List<SongList> songList =songServiceDAO.getSongList();
		return songList;
	}
}
