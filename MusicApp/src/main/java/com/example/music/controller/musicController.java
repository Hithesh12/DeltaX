package com.example.music.controller;

import java.text.ParseException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.model.Artist;
import com.example.music.model.ArtistList;
import com.example.music.model.Song;
import com.example.music.model.SongList;
import com.example.music.service.ArtistService;
import com.example.music.service.SongService;

@RestController
public class musicController {

	@Autowired
	SongService songService;
	
	@Autowired
	ArtistService artistService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songs", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Song> getSongs() {
		List<Song> listOfSongs = songService.getAllSongs();
		System.out.println("List of songs:"+listOfSongs);
		return listOfSongs;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Song getSong(@PathVariable int id) {
		return songService.getSong(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songs", method = RequestMethod.POST, headers = "Accept=application/json")
	public Song addSong(@RequestBody Song song) throws ParseException {
		return songService.addSong(song);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Song updateSong(@RequestBody Song song, @PathVariable("id") int id) {
		return songService.updateSong(id, song);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteSong(@PathVariable("id") int id) {
		songService.deleteSong(id);
	}	

	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artists", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Artist> getArtists() {
		List<Artist> listOfArtists = artistService.getAllArtists();
		return listOfArtists;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artists/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Artist getArtist(@PathVariable int id) {
		return artistService.getArtist(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artists", method = RequestMethod.POST, headers = "Accept=application/json")
	public Artist addArtist(@RequestBody Artist artist) throws ParseException {
		return artistService.addArtist(artist);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artists/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Artist updateArtist(@RequestBody Artist artist, @PathVariable("id") int id) {
		return artistService.updateArtist(id, artist);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artists/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteArtist(@PathVariable("id") int id) {
		artistService.deleteArtist(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/songList", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<SongList> getSongList() {
		List<SongList> songList = songService.getSongList();
		return songList;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/artistList", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<ArtistList> getArtistList() {
		List<ArtistList> artistList = artistService.getArtistList();
		return artistList;
	}
}
