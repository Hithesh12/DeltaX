package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.SongServiceDAO;
import com.example.music.model.Song;

@Service("songService")
public class SongServiceImpl implements SongService{

	@Autowired
	SongServiceDAO songServiceDAO;
	
	@Override
	public List<Song> getAllSongs() {
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

}
