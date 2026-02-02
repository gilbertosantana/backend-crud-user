package com.github.gilbertosantana.apiUser.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;

import com.github.gilbertosantana.apiUser.dto.request.UserRequestDTO;
import com.github.gilbertosantana.apiUser.model.User;
import com.github.gilbertosantana.apiUser.model.enums.Profile;
import com.github.gilbertosantana.apiUser.model.mapper.UserMapper;

import jakarta.persistence.EntityManager;

@DataJpaTest
@ActiveProfiles("test")
class UserRepositoryTest {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	EntityManager entityManager;
	
	@Test
	@DisplayName("Disabled users should not be obtained")
	void testFindByActiveTrueError() {
		UserRequestDTO data = new UserRequestDTO("Gilberto Santana", 
												"gilberto@gmail.com", 
												"@12345B", 
												"83994191521", "13738143418",
												Profile.ADMIN);
		this.createUser(data);
		Pageable pg = PageRequest.of(0, 10);
		Page<User> result = this.userRepository.findByActiveTrue(pg);
		assertThat(result.isEmpty()).isTrue();
		//assertEquals(result.isEmpty(), true);
	}

	private User createUser(UserRequestDTO data) {
		User newUser = UserMapper.toEntity(data);
		this.entityManager.persist(newUser);
		return newUser;
	}
}
