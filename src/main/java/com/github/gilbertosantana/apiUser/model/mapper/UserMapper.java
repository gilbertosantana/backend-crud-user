package com.github.gilbertosantana.apiUser.model.mapper;

import org.springframework.stereotype.Component;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.request.UserUpdateDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;

@Component
public class UserMapper {
	
	public static User toEntity(UserRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setTelephone(dto.getTelephone());
		user.setCpf(dto.getCpf());
		user.setProfile(dto.getProfile());
		return user;
		
	}
	
	public static User toEntity(UserResponseDTO dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setProfile(dto.getProfile());
		return user;
		
	}
	
	public static UserRequestDTO toRequestDto(User user) {
		UserRequestDTO dto = new UserRequestDTO();
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setPassword(user.getPassword());
		dto.setTelephone(user.getTelephone());
		dto.setCpf(user.getCpf());
		dto.setProfile(user.getProfile());
		return dto;
		
	}
	
	public static UserResponseDTO toResponseDto(User user) {
		UserResponseDTO dto = new UserResponseDTO();
		dto.setId(user.getId());
		dto.setName(user.getName());
		dto.setEmail(user.getEmail());
		dto.setProfile(user.getProfile());
		return dto;
		
	}
	
	public static void updateDate(User entity, UserUpdateDTO dto) {
		entity.setName(dto.getName());
		entity.setEmail(dto.getEmail());
		entity.setTelephone(dto.getTelephone());
		entity.setCpf(dto.getCpf());
		entity.setProfile(Profile.valueOf(dto.getProfile()));
	}
}
