package com.github.gilbertosantana.apiUser.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;
import com.github.gilbertosantana.apiUser.repository.UserRepository;
import com.github.gilbertosantana.apiUser.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
	
	public UserResponseDTO update(Long id, UserRequestDTO obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			updateDate(obj, entity);
			userRepository.save(entity);
			UserResponseDTO objDTO = new UserResponseDTO(entity);
			return objDTO;
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Page<UserResponseDTO> findAll(Pageable pageable) {
		Page<User> page = userRepository.findByActiveTrue(pageable);
		Page<UserResponseDTO> pageDTO = page.map(x -> new UserResponseDTO(x));
		return pageDTO;
	}
	
	public UserResponseDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		Optional<UserResponseDTO> objDto = obj.map(x -> new UserResponseDTO(obj.get()));
		return objDto.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete(Long id) {
		if(!userRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		userRepository.deleteById(id);
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

	private void updateDate(UserRequestDTO obj, User entity) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setTelephone(obj.getTelephone());
		entity.setCpf(obj.getCpf());
		entity.setProfile(Profile.valueOf(obj.getProfile()));
	}
}
