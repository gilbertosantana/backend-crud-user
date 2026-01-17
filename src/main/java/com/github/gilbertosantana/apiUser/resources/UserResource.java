package com.github.gilbertosantana.apiUser.resources;

import java.time.LocalDate;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<User> findAll() {
		User u1 = new User(1L, "Gilberto", "gilbertosantoss307@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.ADMIN);
		return ResponseEntity.ok().body(u1);
	}
}
