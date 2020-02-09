package model.data.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Formulaire;
import model.PaiementAndReceipt;
import model.TypeInscription;
import model.data.FormulairePayeRepository;

@Repository
public class JdbcFormulairePayed implements FormulairePayeRepository {
	private JdbcTemplate jdbc;

	@Autowired
	public JdbcFormulairePayed(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	@Override
	public Formulaire addFormulairePayed(Formulaire form, PaiementAndReceipt par) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		Date date = new Date();
		System.out.println(par.getCcCVV() + " " + par.getCcExpiration() + " " + par.getCcNumber());
		jdbc.update(
				"insert into FormulairesPayes (title, firstname, lastname, institution, address, "
						+ "zip, city, country, email, phone, idconference, idtype, datepaiement, ccnumber, cccv, ccexpiration, recuEnvoye)"
						+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, parsedatetime(?, 'dd-MM-yy HH:mm:ss'), ?, ?, ?, ?)",
				form.getTitle(), form.getFirstName(), form.getLastName(), form.getInstitution(), form.getAddress(),
				form.getZip(), form.getCity(), form.getCountry(), form.getEmail(), form.getPhone(), 
				Integer.parseInt(form.getIdConference()),
				Integer.parseInt(form.getIdType()), 
				formatter.format(date), 
				Long.parseLong(par.getCcNumber()), 
				Integer.parseInt(par.getCcCVV()), 
				par.getCcExpiration(), false);
		return form;
	}

	private PaiementAndReceipt mapRowToPaiementAndReceipt(ResultSet rs, int rowNum) throws SQLException {
		PaiementAndReceipt res = new PaiementAndReceipt();
		res.setTitle(rs.getString("title"));
		res.setFirstName(rs.getString("firstName"));
		res.setLastName(rs.getString("lastName"));
		res.setInstitution(rs.getString("institution"));
		res.setAddress(rs.getString("address"));
		res.setZip(rs.getString("zip"));
		res.setCity(rs.getString("city"));
		res.setCountry(rs.getString("country"));
		res.setEmail(rs.getString("email"));
		res.setPhone(rs.getString("phone"));
		res.setIdConference(rs.getString("idConference"));
		res.setIdType(rs.getString("idType"));	
		res.setDatepaiement(rs.getDate("datepaiement"));
		res.setCcNumber(rs.getString("ccnumber"));
		res.setCcExpiration(rs.getString("ccexpiration"));
		res.setCcCVV(rs.getString("cccv"));
		res.setRecuEnvoye(rs.getBoolean("recuEnvoye"));
		return res;
	}
	
	@Override
	public Iterable<PaiementAndReceipt> findAllNoSendFacture() {
		return jdbc.query("select * from FormulairesPayes where recuEnvoye=false", this::mapRowToPaiementAndReceipt);
	}

	@Override
	public Iterable<PaiementAndReceipt> findAllNoSendFacture(Long idConference) {
		return jdbc.query("select * from FormulairesPayes where recuEnvoye=false and idconference=?", this::mapRowToPaiementAndReceipt, idConference);
	}

	@Override
	public void validatedSendReceipt(Long idreceip) {
		jdbc.update("update FormulairesPayes set recuEnvoye=true where id=?", idreceip);
	}
}

/*
 * 379354508162306
 * */
 