package com.github.gilbertosantana.apiUser.resources;




import java.net.URI;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.dto.request.UserUpdateDTO;
import com.github.gilbertosantana.apiUser.dto.response.UserResponseDTO;
import com.github.gilbertosantana.apiUser.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	private final UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public ResponseEntity<UserResponseDTO> insert(@RequestBody UserRequestDTO objDto) {
		UserResponseDTO obj = userService.insert(objDto);
		URI uri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/{id}")
				.buildAndExpand(obj.getId())
				.toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UserResponseDTO> update(@PathVariable Long id, @RequestBody UserUpdateDTO obj) {
			UserResponseDTO response = userService.update(id, obj);
			return ResponseEntity.ok().body(response);
	}
	
	@GetMapping
	public ResponseEntity<List<UserResponseDTO>> findAll(Pageable pageable) {
		List<UserResponseDTO> page = userService.findAll(pageable).getContent();
		return ResponseEntity.ok().body(page);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UserResponseDTO> findById(@PathVariable Long id) {
		UserResponseDTO objDto = userService.findById(id);
		return ResponseEntity.ok().body(objDto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
