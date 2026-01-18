package com.github.gilbertosantana.apiUser.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.ControllerAdvice;

import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;
import com.github.gilbertosantana.apiUser.repository.UserRepository;

@ControllerAdvice
public class TestConfig implements CommandLineRunner{

	private final UserRepository userRepository;
	
	public TestConfig(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Gilberto", "gilbertosantoss307@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.ADMIN); 
		User u2 = new User(null, "João", "joao@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.SUPPORT); 
		User u3 = new User(null, "Joelma", "joelma@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.ADMIN); 
		User u4 = new User(null, "Vitório", "vitorio@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.USER); 
		User u5 = new User(null, "Pedro", "pedro@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.USER); 
		User u6 = new User(null, "Belinha", "gilbertosantoss307@gmail.com", "1234567", LocalDate.now(), true, LocalDate.now(), "83994191521", "12345678910", Profile.ADMIN);
		
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5, u6));
	}

}
