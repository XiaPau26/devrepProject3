package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import model.User;
import model.data.UserRepository;

@Repository
public class JdbcUser implements UserRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcUser(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public User findByUsername(String username) {
		List<User> list = jdbc.query("select * from users where username=?", this::mapRowToUser, username);

		if (list.size() == 0)
			return null;

		User res = list.get(0);
		User auth = jdbc.queryForObject("select * from AUTHORITIES where username=?", this::mapRowToAuthority,
				username);
		res.setAuthority(auth.getAuthority());
		return res;
	}

	private User mapRowToAuthority(ResultSet rs, int rowNum) throws SQLException {
		User res = new User();
		res.setUsername(rs.getString("username"));
		res.setAuthority(rs.getString("authority"));
		return res;
	}

	private User mapRowToUser(ResultSet rs, int rowNum) throws SQLException {
		User res = new User();
		res.setUsername(rs.getString("username"));
		res.setPassword(rs.getString("password"));
		return res;
	}

	@Override
	public void save(User user) {
		jdbc.update("insert into users (username, password, enabled)" + "values (?, ?, ?)", user.getUsername(),
				new BCryptPasswordEncoder().encode(user.getPassword()), true);
		jdbc.update("insert into AUTHORITIES (username, authority) values (?, ?)", user.getUsername(), "ROLE_STAFF");
	}

	@Override
	public Iterable<User> findSimpleAdmin() {
		return jdbc.query("select * from AUTHORITIES where authority=?", this::mapRowToAuthority, "ROLE_STAFF");
	}
}
