package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.Song;
import com.example.music.model.SongList;

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
				"INSERT INTO Song (name, Date_of_release, Image, Rating)VALUES (?,?,?,?)",
				new Object[] { song.getName(), song.getDate_of_release(), song.getImage(), song.getRating()});
		return song;
	}

	@Override
	public Song updateSong(int id, Song song) {
		jdbcTemplate.update(
				"UPDATE Song set name = ?, Date_of_release = ?, Image = ?, Rating = ? where Song_id = ?",
				new Object[] { song.getName(), song.getDate_of_release(), song.getImage(), song.getRating(),
						 id});
		return song;
	}

	@Override
	public void deleteSong(int id) {
		jdbcTemplate.update("DELETE from Song where Song_id = ?", new Object[] { id });
	}

	@Override
	public void updateSong(int id, int rating) {
		jdbcTemplate.update(
				"UPDATE Song set Rating = ? where Song_id = ?",
				new Object[] { rating, id});
	}

	@Override
	public List<SongList> getSongList() {
		List<SongList> songList = null;
		try {
			songList = jdbcTemplate.query("SELECT `s`.`song_id`,\r\n"
					+ "       `s`.`name`,\r\n"
					+ "       `s`.rating,\r\n"
					+ "       `s`.Date_of_release,\r\n"
					+ "        GROUP_CONCAT(`a`.`Artist_name`) `artists`\r\n"
					+ "FROM `association` \r\n"
					+ "JOIN `song` s ON `s`.`Song_id`=`association`.`Song_id`\r\n"
					+ "JOIN `artist` a ON `a`.`Artist_id`=`association`.`Artist_id`\r\n"
					+ "GROUP BY `s`.`Song_id`,\r\n"
					+ "         `s`.`name`;", new BeanPropertyRowMapper<SongList>(SongList.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		System.out.println(songList.toString());
		return songList;
	}
	
}
