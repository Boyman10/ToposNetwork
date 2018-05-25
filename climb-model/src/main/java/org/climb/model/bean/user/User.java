package org.climb.model.bean.user;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class handling User entity
 * @author bob
 * @version 1.1
 */
public class User {

	private int id;
	private String username;
	private String password;
	private String datereg;
	private String email;
	private String gravatar;
	private Role role;
	
	/**
	 * Entity Constructor to initialize data
	 */
	public User() {
		setDefaultDate(); 
	}
	
	/**
	 * @return the gravatar
	 */
	public String getGravatar() {
		return gravatar;
	}

	/**
	 * @param gravatar the gravatar to set
	 */
	public void setGravatar(String gravatar) {
		this.gravatar = gravatar;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the datereg
	 */
	public String getDatereg() {
		return datereg;
	}
	/**
	 * @param datereg the datereg to set
	 */
	public void setDatereg(String datereg) {
		this.datereg = datereg;
	}
	
	/**
	 * Define the default date for new entry
	 */
	public void setDefaultDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		this.datereg = sdf.format(new Date());
	}
	
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	
	
	
}
