package com.example.music.DAO;

import java.util.List;

import com.example.music.model.Artist;

public interface ArtistServiceDAO {

	Artist getArtist(int id);

	List<Artist> getAllArtists();

}
