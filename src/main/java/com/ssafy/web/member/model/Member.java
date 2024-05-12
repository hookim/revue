package com.ssafy.web.member.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Member {
	@Id
	private String id;

	private String name;
	private String email;
	private String pw;
	private String ssn;

	public Member() {
		super();
	}

	public Member(String id, String name, String email, String pw, String ssn) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.pw = pw;
		this.ssn = ssn;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	@Override
	public String toString() {
		return "Member{" +
				"id='" + id + '\'' +
				", name='" + name + '\'' +
				", email='" + email + '\'' +
				", pw='" + pw + '\'' +
				", ssn='" + ssn + '\'' +
				'}';
	}
}
