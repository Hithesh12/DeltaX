package com.example.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.music.DAO.ArtistServiceDAO;
import com.example.music.model.Artist;

@Service("artistService")
public class ArtistServiceImpl implements ArtistService {
	@Autowired
	ArtistServiceDAO artistServiceDAO;
	
	@Override
	public List<Artist> getAllArtists() {
		List<Artist> artists = artistServiceDAO.getAllArtists();
		return artists;
	}

	@Override
	public Artist getArtist(int id) {
		Artist artist = artistServiceDAO.getArtist(id);
		return artist;
	}

	@Override
	public Artist addArtist(Artist artist) {
		artistServiceDAO.addArtist(artist);
		return artist;
	}

	@Override
	public Artist updateArtist(int id, Artist artist) {
		artistServiceDAO.updateArtist(id, artist);
		return artist;
	}

	@Override
	public void deleteArtist(int id) {
		artistServiceDAO.deleteArtist(id);
	}
}
