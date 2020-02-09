package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.URL;
import model.data.UrlRepository;

@Repository
public class JdbcUrl implements UrlRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcUrl(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	private URL mapRowToUrl(ResultSet rs, int rowNum) throws SQLException {
		URL res = new URL();
		res.setUrl(rs.getString("url"));
		res.setDateExpiration(rs.getString("dateExpiration"));
		return res;
	}

	@Override
	public void save(URL url) {
//		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy hh:mm:ss");
//		String expiration = sdf.format(url.getDateExpiration());
//		url.setDateExpiration(sdf.parse(expiration));
		jdbc.update("insert into URLs (url, dateExpiration) values (?, ?)", url.getUrl(), url.getDateExpiration());
	}

	@Override
	public Iterable<URL> findAllUrl() {
		return jdbc.query("select * from URLs", this::mapRowToUrl);
	}

	@Override
	public URL findOneUrl(String url) {
		return jdbc.queryForObject("select * from URLs where url=?", this::mapRowToUrl, url);
	}

	@Override
	public void delete(long id) {
		jdbc.update("delete from URLs where url=?", "http://localhost:8080/paiement/" + id);
	}

}
