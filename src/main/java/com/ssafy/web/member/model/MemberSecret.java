package com.ssafy.web.member.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class MemberSecret {

	@Id
	private String id;

	private String salt, ssn_key;
	
	public MemberSecret() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MemberSecret(String id, String salt, String ssn_key) {
		this.id = id;
		this.salt = salt;
		this.ssn_key = ssn_key;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getSsn_key() {
		return ssn_key;
	}

	public void setSsn_key(String ssn_key) {
		this.ssn_key = ssn_key;
	}
}
