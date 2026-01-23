package com.github.gilbertosantana.apiUser.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;
import com.github.gilbertosantana.apiUser.model.mapper.UserMapper;
import com.github.gilbertosantana.apiUser.repository.UserRepository;
import com.github.gilbertosantana.apiUser.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	private final UserMapper userMapper;
	
	public UserService(UserRepository userRepository, UserMapper userMapper) {
		this.userRepository = userRepository;
		this.userMapper = userMapper;
	}
	
	public UserResponseDTO insert(UserRequestDTO objDto) {
		User obj = userMapper.toEntity(objDto);
		userRepository.save(obj);
		return userMapper.toResponsDto(obj);
		
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

	private void updateDate(UserRequestDTO obj, User entity) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPassword(obj.getPassword());
		entity.setTelephone(obj.getTelephone());
		entity.setCpf(obj.getCpf());
		entity.setProfile(Profile.valueOf(obj.getProfile()));
	}
}
