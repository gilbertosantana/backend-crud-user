package com.github.gilbertosantana.apiUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.gilbertosantana.apiUser.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
