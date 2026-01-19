package com.github.gilbertosantana.apiUser.dto.request;

import com.github.gilbertosantana.apiUser.model.enums.Profile;

public class UserRequestDTO {

	private String name;
	private String email;
	private String password;
	private String telephone;
	private String cpf;
	private Integer profile;
	
	public UserRequestDTO() {
		
	}
	
	public UserRequestDTO(String name, String email, String password, String telephone, String cpf, Profile profile) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.telephone = telephone;
		this.cpf = cpf;
		this.profile = profile.getCode();
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile.getCode();
	}
}
