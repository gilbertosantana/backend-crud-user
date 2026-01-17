package com.github.gilbertosantana.apiUser.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.github.gilbertosantana.apiUser.model.enums.Profile;

public class User implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private LocalDate creationDate;
	private Boolean active;
	private LocalDate updateDate;
	private String telephone;
	private String cpf;
	private Integer profile;
	
	public User() {
	}

	public User(Long id, String name, String email, String password, LocalDate creationDate, Boolean active,
			LocalDate updateDate, String telephone, String cpf, Profile profile) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.creationDate = creationDate;
		this.active = active;
		this.updateDate = updateDate;
		this.telephone = telephone;
		this.cpf = cpf;
		this.profile = profile.getCode();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDate getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDate creationDate) {
		this.creationDate = creationDate;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public LocalDate getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDate updateDate) {
		this.updateDate = updateDate;
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

	public Profile getProfile() {
		return Profile.valueOf(profile);
	}

	public void setProfile(Profile profile) {
		if(profile != null) {
			this.profile = profile.getCode();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(active);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(active, other.active);
	}

	
}
