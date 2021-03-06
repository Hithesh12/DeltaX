package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.ArtistList;
import com.example.music.model.SongRating;

@Repository("songRatingServiceDAO")
public class SongRatingServiceDAOImpl implements SongRatingServiceDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public SongRating getRating(int id) {
		SongRating songRating = null;
		try {
			songRating = jdbcTemplate.queryForObject("SELECT * FROM Song_Rating WHERE Rating_id = ?",
					new Object[] { id }, new BeanPropertyRowMapper<SongRating>(SongRating.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return songRating;
	}

	@Override
	public List<SongRating> getAllRatings() {
		List<SongRating> songRatings = null;
		try {
			songRatings = jdbcTemplate.query("SELECT * from Song_Rating",
					new BeanPropertyRowMapper<SongRating>(SongRating.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return songRatings;
	}

	@Override
	public SongRating addRating(SongRating songRating) {
		jdbcTemplate.update("INSERT INTO Song_Rating (Rating_id, Rating, Song_id) VALUES (?,?,?)",
				new Object[] { songRating.getRating_id(), songRating.getRating(), songRating.getSong_id() });
		return songRating;
	}

	@Override
	public SongRating updateSongRating(int id, SongRating songRating) {
		jdbcTemplate.update("UPDATE Song_Rating set Rating = ? where Song_id = ?",
				new Object[] { songRating.getRating(), id });
		return songRating;
	}

	@Override
	public void deleteRating(int id) {
		jdbcTemplate.update("DELETE from Song_Rating where Song_id = ?", new Object[] { id });
	}

	@Override
	public List<SongRating> getAllRatings(int id) {
		List<SongRating> songRatings = null;
		try {
			songRatings = jdbcTemplate.query("SELECT * from Song_Rating WHERE Song_id = ?",
					new Object[] { id }, new BeanPropertyRowMapper<SongRating>(SongRating.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return songRatings;
	}


}
