package model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class TypeInscription {
	private @Id @GeneratedValue Long id;
	private String libelle;
	private int tarifearly;
	private int tariflate;
	private Date date;
	private int tarif;
	
	public String getLibelle() {
		return libelle;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getTarifearly() {
		return tarifearly;
	}

	public void setTarifearly(int tarifearly) {
		this.tarifearly = tarifearly;
	}

	public int getTariflate() {
		return tariflate;
	}

	public void setTariflate(int tariflate) {
		this.tariflate = tariflate;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTarif() {
		return tarif;
	}

	public void setTarif(int tarif) {
		this.tarif = tarif;
	}

}