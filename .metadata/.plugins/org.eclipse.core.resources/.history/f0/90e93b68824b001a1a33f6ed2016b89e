package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Formulaire {

	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Title is required")
	private String title;
	@NotBlank(message = "Firstname is required")
	private String firstName;
	@NotBlank(message = "Lastname is required")
	private String lastName;
	@NotBlank(message = "institution is required")
	private String institution;
	@NotBlank(message = "addresse is required")
	private String address;
	@NotBlank(message = "zip is required")
	private String zip;
	@NotBlank(message = "city is required")
	private String city;
	@NotBlank(message = "country is required")
	private String country;
	// @Pattern(regexp = "^([0-9a-zA-z\\-\\_\\.]+)@([a-zA-Z]+)\\.([a-zA-Z]+)$",
	// message = "mail format incorrect")
	private String email;
	// @Pattern(regexp = "^(0|\\+33 )[1-9]([-. ]?[0-9]{2} ){3}([-. ]?[0-9]{2})$",
	// message = "phone number must be 0X XX XX XX XX or +33 X XX XX XX XX format")
	private String phone;
	private String idConference;
	private String idType;
	private int validated;	
	
	public Formulaire(@NotBlank(message = "Title is required") String title,
			@NotBlank(message = "Firstname is required") String firstName,
			@NotBlank(message = "Lastname is required") String lastName,
			@NotBlank(message = "institution is required") String institution,
			@NotBlank(message = "addresse is required") String address,
			@NotBlank(message = "zip is required") String zip, @NotBlank(message = "city is required") String city,
			@NotBlank(message = "country is required") String country, String email, String phone, String idConference,
			String idType) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.institution = institution;
		this.address = address;
		this.zip = zip;
		this.city = city;
		this.country = country;
		this.email = email;
		this.phone = phone;
		this.idConference = idConference;
		this.idType = idType;
	}

	public Formulaire(Formulaire f) {

	}

	public int getValidated() {
		return validated;
	}

	public void setValidated(int v) {
		this.validated = v;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public void setIdType(String idType) {
		this.idType = idType;
	}
}
