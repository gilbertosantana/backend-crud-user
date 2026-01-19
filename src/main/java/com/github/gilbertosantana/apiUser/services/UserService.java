package com.github.gilbertosantana.apiUser.services;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;
import com.github.gilbertosantana.apiUser.repository.UserRepository;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User insert(UserRequestDTO objDto) {
		User obj = toEntity(objDto);
		return userRepository.save(obj);
	}
	
	public Page<UserResponseDTO> findAll(Pageable pageable) {
		Page<User> page = userRepository.findAll(pageable);
		Page<UserResponseDTO> pageDTO = page.map(x -> new UserResponseDTO(x));
		return pageDTO;
	}
	
	public User toEntity(UserRequestDTO dto) {
		User user = new User();
		user.setName(dto.getName());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		user.setCreationDate(LocalDate.now());
		user.setActive(true);
		user.setUpdateDate(LocalDate.now());
		user.setTelephone(dto.getTelephone());
		user.setCpf(dto.getCpf());
		user.setProfile(Profile.valueOf(dto.getProfile()));
		return user;
	}
}
