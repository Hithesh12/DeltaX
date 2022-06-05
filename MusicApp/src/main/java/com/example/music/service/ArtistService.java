package com.example.music.service;

import java.util.List;

import com.example.music.model.Artist;

public interface ArtistService {
	public List<Artist> getAllArtists();
	
	public Artist getArtist(int id);
}
