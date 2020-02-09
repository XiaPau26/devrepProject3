package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.AdminConf;
import model.data.AdminConfRepository;

@Repository
public class JdbcAdminConf implements AdminConfRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcAdminConf(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	private AdminConf mapRowToAdminConf(ResultSet rs, int rowNum) throws SQLException {
		AdminConf res = new AdminConf();
		res.setAdmin(rs.getString("admin"));
		res.setConfenrece(rs.getLong("idConference"));
		return res;
	}

	@Override
	public void save(List<AdminConf> form) {
		for (AdminConf ac : form)
			jdbc.update("insert into AdminConf (admin, idConference) values (?, ?)", ac.getAdmin(), ac.getConfenrece());
	}

	@Override
	public Iterable<AdminConf> findConfByAdmin(String admin) {
		return jdbc.query("select * from AdminConf where admin=?", this::mapRowToAdminConf, admin);
	}

	@Override
	public void delete(String admin) {
		jdbc.update("delete from AdminConf where admin=?", admin);
	}

}
