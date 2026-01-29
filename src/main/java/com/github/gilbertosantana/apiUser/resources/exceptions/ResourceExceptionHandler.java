package com.github.gilbertosantana.apiUser.resources.exceptions;

import java.time.Instant;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.github.gilbertosantana.apiUser.services.exceptions.ResourceNotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError>  resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found";
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> methodArgumentNotValid(MethodArgumentNotValidException e) {
		ApiError response = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation failed");
		
		e.getBindingResult().getFieldErrors().forEach(error -> {
			response.addError(error.getField(), error.getDefaultMessage());
		});

		return ResponseEntity.badRequest().body(response);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ApiError> httpMessageNotReadable(HttpMessageNotReadableException e, HttpServletRequest request) {
		ApiError error = new ApiError(HttpStatus.BAD_REQUEST.value(), "Validation failed");
		error.addError("profile", "The profile must be one of the following values: USER, ADMIN, or SUPPORT");
		return ResponseEntity.badRequest().body(error);
	}
}
