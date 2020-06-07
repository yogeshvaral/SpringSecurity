package org.studyeasy.spring.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncodingService {
	public String passwordEncoder(String password) {
		BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
		return encode.encode(password);
	}
}
