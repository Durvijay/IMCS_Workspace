package com.springboot.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties
public class User {
	private String username;
	private String password;

}
