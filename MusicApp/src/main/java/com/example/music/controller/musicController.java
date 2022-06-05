package com.example.music.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.music.model.Artist;
import com.example.music.model.Song;
import com.example.music.model.User;
import com.example.music.service.ArtistService;
import com.example.music.service.SongService;
import com.example.music.service.UserService;

@RestController
public class musicController {

	@Autowired
	SongService songService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	ArtistService artistService;
	
	@RequestMapping(value = "/songs", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Song> getSongs() {
		List<Song> listOfSongs = songService.getAllSongs();
		return listOfSongs;
	}
	
	@RequestMapping(value = "/songs/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Song getSong(@PathVariable int id) {
		return songService.getSong(id);
	}
	

	@RequestMapping(value = "/songs", method = RequestMethod.POST, headers = "Accept=application/json")
	public Song addSong(@RequestBody Song song) throws ParseException {
		
		return songService.addSong(song);
	}

	@RequestMapping(value = "/songs/{id}", method = RequestMethod.PUT, headers = "Accept=application/json")
	public Song updateSong(@RequestBody Song song, @PathVariable("id") int id) {
		return songService.updateSong(id, song);
	}

	@RequestMapping(value = "/songs/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
	public void deleteSong(@PathVariable("id") int id) {
		songService.deleteSong(id);
	}	

	@RequestMapping(value = "/users", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<User> getUsers() {
		List<User> listOfUsers = userService.getAllUsers();
		return listOfUsers;
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public User getUser(@PathVariable int id) {
		return userService.getUser(id);
	}
	
	@RequestMapping(value = "/artists", method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Artist> getArtists() {
		List<Artist> listOfArtists = artistService.getAllArtists();
		return listOfArtists;
	}
	
	@RequestMapping(value = "/artists/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Artist getArtist(@PathVariable int id) {
		return artistService.getArtist(id);
	}
}
