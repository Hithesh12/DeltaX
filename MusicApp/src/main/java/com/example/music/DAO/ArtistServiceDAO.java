package com.example.music.DAO;

import java.util.List;

import com.example.music.model.Artist;

public interface ArtistServiceDAO {

	Artist getArtist(int id);

	List<Artist> getAllArtists();
	
	public Artist addArtist(Artist artist);
	
	public Artist updateArtist(int id, Artist artist);
	
	public void deleteArtist(int id);

}
