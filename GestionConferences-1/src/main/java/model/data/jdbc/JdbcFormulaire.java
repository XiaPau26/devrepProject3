package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Formulaire;
import model.TypeInscription;
import model.data.FormulaireRepository;

@Repository
public class JdbcFormulaire implements FormulaireRepository {

	private JdbcTemplate jdbc;

	@Autowired
	public JdbcFormulaire(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public void save(Formulaire form) {
		jdbc.update(
				"insert into Formulaires (title, firstname, lastname, institution, address, zip, city, country, email, phone, idconference, idtype, validated) "
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)",
				form.getTitle(), form.getFirstName(), form.getLastName(), form.getInstitution(), form.getAddress(),
				form.getZip(), form.getCity(), form.getCountry(), form.getEmail(), form.getPhone(),
				Integer.parseInt(form.getIdConference()), Integer.parseInt(form.getIdType()), 0);
	}

	@Override
	public Iterable<TypeInscription> findAllTypeInscription() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		String curr = sdf.format(new Date());
		Iterable<TypeInscription> list = jdbc.query("select * from TypeInscription", this::mapRowToTypeInscription);
		for (TypeInscription ti : list) {
			String dateconf = (sdf.format(ti.getDate()).split(" "))[0];
			if (curr.equals(dateconf)) {
				ti.setTarif(ti.getTariflate());
			} else {
				ti.setTarif(ti.getTarifearly());
			}
		}
		return list;
	}

	private TypeInscription mapRowToTypeInscription(ResultSet rs, int rowNum) throws SQLException {
		TypeInscription res = new TypeInscription();
		res.setId(rs.getLong("id"));
		res.setDate(rs.getDate("dateconf"));
		res.setLibelle(rs.getString("libelle"));
		res.setTarifearly(rs.getInt("tarifearly"));
		res.setTariflate(rs.getInt("tariflate"));
		return res;
	}

	private Formulaire mapRowToFormulaire(ResultSet rs, int rowNum) throws SQLException {
		Formulaire res = new Formulaire(null);
		res.setId(rs.getLong("id"));
		res.setTitle(rs.getString("title"));
		res.setFirstName(rs.getString("firstname"));
		res.setLastName(rs.getString("lastname"));
		res.setInstitution(rs.getString("institution"));
		res.setAddress(rs.getString("address"));
		res.setZip(rs.getString("zip"));
		res.setCity(rs.getString("city"));
		res.setCountry(rs.getString("country"));
		res.setEmail(rs.getString("email"));
		res.setPhone(rs.getString("phone"));
		res.setIdConference(rs.getString("idconference"));
		res.setIdType(rs.getString("idtype"));
		res.setValidated(rs.getInt("validated"));
		return res;
	}

	@Override
	public Iterable<Formulaire> findAll() {
		return jdbc.query("select * from Formulaires", this::mapRowToFormulaire);
	}

	@Override
	public Formulaire findOneFormulaire(long idFormulaire) {
		return jdbc.queryForObject("select * from Formulaires where id=?", this::mapRowToFormulaire, idFormulaire);
	}

	@Override
	public TypeInscription findOneTypeInscription(long idtype) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
		String curr = sdf.format(new Date());
		TypeInscription ti = jdbc.queryForObject("select * from TypeInscription where id=?",
				this::mapRowToTypeInscription, idtype);
		String dateconf = (sdf.format(ti.getDate()).split(" "))[0];
		if (curr.equals(dateconf)) {
			ti.setTarif(ti.getTariflate());
		} else {
			ti.setTarif(ti.getTarifearly());
		}
		return ti;
	}

	@Override
	public void delete(Formulaire form) {
		jdbc.update("delete from Formulaires where id=?", form.getId());
	}

	@Override
	public void delete(long id) {
		jdbc.update("delete from Formulaires where id=?", id);
	}

	@Override
	public void validatedForm(int form) {
		jdbc.update("update FORMULAIRES set validated=1 where id=?", form);
	}

	@Override
	public Iterable<Formulaire> findAllNoValidated() {
		return jdbc.query("select * from Formulaires where validated=0", this::mapRowToFormulaire);
	}

	@Override
	public Iterable<Formulaire> findAllNoValidatedOfConference(Long idConference) {
		return jdbc.query("select * from Formulaires where validated=0 and idconference=?", this::mapRowToFormulaire,
				idConference);
	}
}