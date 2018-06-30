package org.rhm.climb.webapp.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Password encoder and verification tool
 * @author Boyman
 * @version 0.1.0
 */
public class PasswordEncoder {

	/*
	 *  Method returning an encoded password using Bcrypt from Spring Security
	 *  @param String password
	 *  @return String password
	 */
	public String encodePassword(String password) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		return hashedPassword;
		
	}
	
	/**
	 * Return is password match or not using Bcrypt
	 * @param password
	 * @param hash
	 * @return
	 */
	public boolean passwordMatch(String password, String hash) {
		
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		
		return bCryptPasswordEncoder.matches(password, hash);
		
	}
}
