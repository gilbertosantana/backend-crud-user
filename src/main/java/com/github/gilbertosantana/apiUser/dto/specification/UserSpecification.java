package com.github.gilbertosantana.apiUser.dto.specification;


import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.github.gilbertosantana.apiUser.dto.filter.UserFilter;
import com.github.gilbertosantana.apiUser.model.User;

import jakarta.persistence.criteria.Predicate;

public class UserSpecification {
	
	public static Specification<User> filter(UserFilter filter) {
		return (root, query, criteriaBuilder) -> {
		
			List<Predicate> predicates = new ArrayList<>();
			
			if(filter.getName() != null && !filter.getName().isEmpty()) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("name")),
								"%" + filter.getName().toLowerCase() + "%"
						)
				);
			}
			if(filter.getEmail() != null && !filter.getEmail().isEmpty()) {
				predicates.add(
						criteriaBuilder.like(
								criteriaBuilder.lower(root.get("email")),
								"%" + filter.getEmail().toLowerCase() + "%"
						)
				);
			}
			
			if(filter.getProfile() != null) {
				predicates.add(criteriaBuilder.equal(
						root.get("profile"),
						filter.getProfile().getCode()
						)
				);
			}
			
			if(filter.getActive() != null) {
				predicates.add(
						criteriaBuilder.equal(
								root.get("active"), 
								filter.getActive()
						)
				);
			}
			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
