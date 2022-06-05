package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.Artist;

@Repository("artistServiceDAO")
public class ArtistServiceDAOImpl implements ArtistServiceDAO{
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Artist> getAllArtists() {
		List<Artist> artists = null;
		try {
			artists = jdbcTemplate.query("SELECT * from Artist", new BeanPropertyRowMapper<Artist>(Artist.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return artists;
	}

	@Override
	public Artist getArtist(int id) {
		Artist artist = null;
		try {
			artist = jdbcTemplate.queryForObject("SELECT * FROM Artist WHERE Song_id = ?", new Object[] { id },
					new BeanPropertyRowMapper<Artist>(Artist.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return artist;
	}
}
