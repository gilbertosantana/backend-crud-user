package com.github.gilbertosantana.apiUser.dto.response;

import com.github.gilbertosantana.apiUser.model.enums.Profile;

public class UserResponseDTO {

	private Long id;
	private String name;
	private String email;
	private Profile profile;
	
	public UserResponseDTO() {
	
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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
}
