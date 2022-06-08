package com.example.music.service;

import java.util.List;

import com.example.music.model.Artist;
import com.example.music.model.ArtistList;

public interface ArtistService {
	public List<Artist> getAllArtists();
	
	public Artist getArtist(int id);
	
	public Artist addArtist(Artist artist);
	
	public Artist updateArtist(int id, Artist artist);
	
	public void deleteArtist(int id);
	
	public List<ArtistList> getArtistList();

}
