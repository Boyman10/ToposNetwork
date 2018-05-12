package org.climb.model.bean.user;

import org.springframework.stereotype.Component;

/**
 * Class handling User entity
 * @author bob
 * @version 1.1
 */
@Component
public class User {

	private int id;
	private String username;
	private String password;
	private String datereg;
	private Role role;
	
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
