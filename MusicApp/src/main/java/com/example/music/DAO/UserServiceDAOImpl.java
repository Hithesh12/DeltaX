package com.example.music.DAO;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.music.model.User;

@Repository("userServiceDAO")
public class UserServiceDAOImpl implements UserServiceDAO {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		try {
			users = jdbcTemplate.query("SELECT * from User", new BeanPropertyRowMapper<User>(User.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return users;
	}

	@Override
	public User getUser(int id) {
		User user = null;
		try {
			user = jdbcTemplate.queryForObject("SELECT * FROM User WHERE User_id = ?", new Object[] { id },
					new BeanPropertyRowMapper<User>(User.class));
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User addUser(User user) {
		jdbcTemplate.update(
				"INSERT INTO User (Name, User_email, Password, Date_of_birth, Security_question, Security_answer) VALUES (?,?,?,?,?,?)",
				new Object[] { user.getName(), user.getUserEmail(), user.getPassword(), user.getDateOfBirth(), user.getSecurityQuestion(), user.getSecurityAnswer() });
		return user;
	}

	@Override
	public User updateUser(int id, User user) {
		jdbcTemplate.update(
				"UPDATE User set Name = ?, User_email = ?, Date_of_birth = ?, Security_question = ?, Security_answer = ? where User_id = ?",
				new Object[] { user.getName(), user.getUserEmail(), user.getDateOfBirth(), user.getSecurityQuestion(), user.getSecurityAnswer(), id});
		return user;
	}

	@Override
	public void deleteUser(int id) {
		jdbcTemplate.update("DELETE from User where User_id = ?", new Object[] { id });
	}
}
