package model;

import javax.persistence.Entity;
import javax.persistence.Id;

public class URL {
	@Id
	private String url;
	private String dateExpiration;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}
}
