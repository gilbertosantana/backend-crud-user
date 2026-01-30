package com.github.gilbertosantana.apiUser.services;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.github.gilbertosantana.apiUser.dto.filter.UserFilter;
import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.request.UserUpdateDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.dto.specification.UserSpecification;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.mapper.UserMapper;
import com.github.gilbertosantana.apiUser.repository.UserRepository;
import com.github.gilbertosantana.apiUser.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {
	
	private final UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserResponseDTO insert(UserRequestDTO objDto) {
		User obj = UserMapper.toEntity(objDto);
		obj.setActive(true);
		obj.setCreationDate(LocalDate.now());
		userRepository.save(obj);
		return UserMapper.toResponsDto(obj);
		
	}
	
	public UserResponseDTO update(Long id, UserUpdateDTO obj) {
		try {
			User entity = userRepository.getReferenceById(id);
			UserMapper.updateDate(entity, obj);
			entity.setUpdateDate(LocalDate.now());
			userRepository.save(entity);
			return UserMapper.toResponsDto(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}
	
	public Page<UserResponseDTO> findAll(UserFilter filter, Pageable pageable) {
		Page<User> page = userRepository.findAll(UserSpecification.filter(filter), pageable);
		Page<UserResponseDTO> pageDto = page.map(UserMapper::toResponsDto);
		return pageDto;
	}
	
	public UserResponseDTO findById(Long id) {
		Optional<User> obj = userRepository.findById(id);
		Optional<UserResponseDTO> objDto = obj.map(UserMapper::toResponsDto);
		return objDto.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	
	public void delete(Long id) {
		if(!userRepository.existsById(id)) {
			throw new ResourceNotFoundException(id);
		}
		userRepository.deleteById(id);
	}
}
