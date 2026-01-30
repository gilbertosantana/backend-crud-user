package com.github.gilbertosantana.apiUser.repository;



import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.github.gilbertosantana.apiUser.model.User;


public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

	Page<User> findByActiveTrue(Pageable page);
}
