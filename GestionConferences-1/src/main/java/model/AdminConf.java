package model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminConf {
	@Id
	private String admin;
	private long confenrece;

	public AdminConf() {
		
	}
	
	public AdminConf(String admin, long conf) {
		this.admin = admin;
		this.confenrece = conf;
	}
	
	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public long getConfenrece() {
		return confenrece;
	}

	public void setConfenrece(long confenrece) {
		this.confenrece = confenrece;
	}
}
