package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.Song;

@Repository("songServiceDAO")
public class SongServiceDAOImpl implements SongServiceDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<Song> getAllSongs() {
		List<Song> songs = null;
		try {
			songs = jdbcTemplate.query("SELECT * from Song", new BeanPropertyRowMapper<Song>(Song.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return songs;
	}

	@Override
	public Song getSong(int id) {
		Song song = null;
		try {
			song = jdbcTemplate.queryForObject("SELECT * FROM Song WHERE Song_id = ?", new Object[] { id },
					new BeanPropertyRowMapper<Song>(Song.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return song;
	}

	@Override
	public Song addSong(Song song) {
		jdbcTemplate.update(
				"INSERT INTO Song (name, Date_of_release, Image, Rating, User_id, Artist_id)VALUES (?,?,?,?,?,?)",
				new Object[] { song.getName(), song.getDate_of_release(), song.getImage(), song.getRating(),
						song.getUser_id(), song.getArtist_id() });
		return song;
	}

	@Override
	public Song updateSong(int id, Song song) {
		jdbcTemplate.update(
				"UPDATE Song set name = ?, Date_of_release = ?, Image = ?, Rating = ?, User_id = ?, Artist_id = ? where Song_id = ?",
				new Object[] { song.getName(), song.getDate_of_release(), song.getImage(), song.getRating(),
						song.getUser_id(), song.getArtist_id(), id});
		return song;
	}

	@Override
	public void deleteSong(int id) {
		jdbcTemplate.update("DELETE from Song where Song_id = ?", new Object[] { id });
	}

}
