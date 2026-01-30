package com.github.gilbertosantana.apiUser.dto.filter;

import java.io.Serializable;

import com.github.gilbertosantana.apiUser.model.enums.Profile;

public class UserFilter implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String email;
	private String telephone;
	private String cpf;
	private Boolean active;
	private Profile profile;
	
	public UserFilter(String name, String email, String telephone, String cpf, Profile profile) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.cpf = cpf;
		this.profile = profile;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
