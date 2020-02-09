package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Conference;
import model.data.ConferenceRepository;

@Repository
public class JdbcConference implements ConferenceRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcConference(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	private Conference mapRowToConference(ResultSet rs, int rowNum) throws SQLException {
		Conference res = new Conference();
		res.setId(rs.getLong("id"));
		res.setName(rs.getString("name"));
		res.setDescription(rs.getString("description"));
		return res;
	}

	@Override
	public void save(Conference form) {
		jdbc.update("insert into Conferences (name, description) values (?, ?)", form.getName(), form.getDescription());
	}

	@Override
	public Iterable<Conference> findAllConference() {
		return jdbc.query("select * from Conferences", this::mapRowToConference);
	}

	@Override
	public Conference findOneConference(long idConference) {
		return jdbc.queryForObject("select * from Conferences where id=?", this::mapRowToConference, idConference);
	}

}