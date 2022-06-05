package com.example.music.DAO;

import java.util.List;

import com.example.music.model.Artist;
import com.example.music.model.Song;
import com.example.music.model.User;

public interface SongServiceDAO {

	public List<Song> getAllSongs();
	
	public Song getSong(int id);
	
	public Song addSong(Song song);
	
	public Song updateSong(int id, Song song);
	
	public void deleteSong(int id);
	
}
