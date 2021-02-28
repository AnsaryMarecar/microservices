package com.catastima.home.bean;
import java.time.LocalDateTime;

public  class Authentification {
	private Long id;
	private String username;
	private String password;
	//private Role role;
	private String token;
	private LocalDateTime auth_date;
	private Long user_id;


	/**
	 * @param username
	 * @param password
	 * @param user_id
	 */
	public Authentification(String username, String password, Long user_id) {
		this.username = username;
		this.password = password;
		this.user_id = user_id;
	}

	/**
	 * 
	 */
	public Authentification() {
	}

	/**
	 * @param id
	 * @param username
	 * @param password
	 */
	public Authentification(Long id, String username, String password) {
		this.id = id;
		this.username = username;
		this.password = password;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	public Role getRole() {
		return role;
	}
 
	public void setRole(Role role) {
		this.role = role;
	}
	**/
	
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	public boolean isTokenCorrect(String token) {
		return (this.token == token);
	}
	
	
	/**
	 */
	public void setToken(String token) {
		this.token = token;
	}


	/**
	 * @return the auth_date
	 */
	public LocalDateTime getAuth_date() {
		return auth_date;
	}
	
	/**
	 * @return the user_id
	 */
	public Long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
 
}