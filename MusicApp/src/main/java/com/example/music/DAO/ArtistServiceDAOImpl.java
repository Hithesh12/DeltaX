package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.Artist;
import com.example.music.model.ArtistList;

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
			artist = jdbcTemplate.queryForObject("SELECT * FROM Artist WHERE Artist_id = ?", new Object[] { id },
					new BeanPropertyRowMapper<Artist>(Artist.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return artist;
	}

	@Override
	public Artist addArtist(Artist artist) {
		jdbcTemplate.update(
				"INSERT INTO Artist (Artist_name, Date_of_birth, Bio)VALUES (?,?,?)",
				new Object[] {artist.getArtist_name(), artist.getDate_of_birth(), artist.getBio()});
		return artist;
	}

	@Override
	public Artist updateArtist(int id, Artist artist) {
		jdbcTemplate.update(
				"UPDATE Artist set Artist_name = ?, Date_of_birth = ?, Bio = ? where Artist_id = ?",
				new Object[] { artist.getArtist_name(), artist.getDate_of_birth(), artist.getBio(), id});
		return artist;
	}

	@Override
	public void deleteArtist(int id) {
		jdbcTemplate.update("DELETE from Artist where Artist_id = ?", new Object[] { id });		
	}

	@Override
	public List<ArtistList> getArtistList() {
		List<ArtistList> artistList = null;
		try {
			artistList = jdbcTemplate.query("SELECT `a`.`Artist_id`,\r\n"
					+ "       `a`.`Artist_name`,\r\n"
					+ "        GROUP_CONCAT(`s`.`name`) `songs`\r\n"
					+ "FROM `association` \r\n"
					+ "JOIN `artist` a ON `a`.`Artist_id`=`association`.`Artist_id`\r\n"
					+ "JOIN `song` s ON `s`.`Song_id`=`association`.`Song_id`\r\n"
					+ "GROUP BY `a`.`Artist_id`,\r\n"
					+ "         `a`.`Artist_name`;", new BeanPropertyRowMapper<ArtistList>(ArtistList.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return artistList;
	}
}
