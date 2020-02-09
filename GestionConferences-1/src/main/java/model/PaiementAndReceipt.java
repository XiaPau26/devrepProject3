package model;

import java.util.Date;

public class PaiementAndReceipt {
	private Long id;

	private Long idFormulaire;
	private String title;
	private String firstName;
	private String lastName;
	private String institution;
	private String address;
	private String zip;
	private String city;
	private String country;
	private String email;
	private String phone;
	private String idConference;
	private String idType;
	private Date datepaiement;
	
	private String ccNumber;
	private String ccExpiration;
	private String ccCVV;
	private boolean recuEnvoye;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdFormulaire() {
		return idFormulaire;
	}

	public void setIdFormulaire(Long idFormulaire) {
		this.idFormulaire = idFormulaire;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdConference() {
		return idConference;
	}

	public void setIdConference(String idConference) {
		this.idConference = idConference;
	}

	public String getIdType() {
		return idType;
	}

	public Date getDatepaiement() {
		return datepaiement;
	}

	public void setDatepaiement(Date datepaiement) {
		this.datepaiement = datepaiement;
	}

	public void setIdType(String idType) {
		this.idType = idType;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public String getCcExpiration() {
		return ccExpiration;
	}

	public void setCcExpiration(String ccExpiration) {
		this.ccExpiration = ccExpiration;
	}

	public String getCcCVV() {
		return ccCVV;
	}

	public void setCcCVV(String ccCVV) {
		this.ccCVV = ccCVV;
	}

	public boolean isRecuEnvoye() {
		return recuEnvoye;
	}

	public void setRecuEnvoye(boolean recuEnvoye) {
		this.recuEnvoye = recuEnvoye;
	}
}
