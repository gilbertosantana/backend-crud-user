package com.github.gilbertosantana.apiUser.resources.exceptions;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class ApiError implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String message;
	private Map<String, String> errors = new HashMap<>();
	
	public ApiError() {
		
	}
	
	public ApiError(Integer status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void addError(String field, String message) {
		errors.put(field, message);
	}
}
