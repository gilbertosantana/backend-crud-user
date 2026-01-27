package com.github.gilbertosantana.apiUser.dto.request;

import org.hibernate.validator.constraints.br.CPF;

import com.github.gilbertosantana.apiUser.model.enums.Profile;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {

	@NotBlank(message = "Name may not be blank")
	@Size(min = 2, max = 50, message = "The name must be longer than {min} and shorter than {max} caracteres")
	private String name;
	@Email(message = "Invalid email address")
	private String email;
	@Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{6,8}$")
	private String password;
	@Pattern(regexp = "^\\d{11}$", message = "The telephone number must have 11 digits")
	private String telephone;
	@CPF(message = "Invalid Brazilian individual taxpayer registration number (CPF)")
	private String cpf;
	@Pattern(regexp = "ADMIN|USER|SUPPORT", message = "Invalid profile")
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
