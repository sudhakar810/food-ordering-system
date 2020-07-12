package com.food.ordering.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Validate {
	
	 private String id;
	 
	 private String password;
	 
	 private String token;

	public String getPassword() {
		return password;
	}

	@JsonIgnoreProperties
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "Validate [id=" + id + ", password=" + password + ", token=" + token + "]";
	}
	 
	
	 
}
