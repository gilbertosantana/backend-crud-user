package com.github.gilbertosantana.apiUser.resources;




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gilbertosantana.apiUser.dto.UserResponseDTO;
import com.github.gilbertosantana.apiUser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@GetMapping
	public ResponseEntity<Page<UserResponseDTO>> findAll(Pageable pageable) {
		Page<UserResponseDTO> page = userService.findAll(pageable);
		return ResponseEntity.ok().body(page);
	}
}
