package com.catastima.authentification.bean;
import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity 
@Table(name = "authentification")
public class Authentification {
	//private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
 
	@Column(name = "username",nullable = false, length = 255)
	private String username;
 
	@Column(name = "password",nullable = false, length = 255)
	private String password;
	
	@Column(name = "user_id",nullable = false)
	private Long user_id;
	
	/**
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id")
	private Role role;
	**/
	@Column(name = "token", nullable = true,length = 250)
	 private String token;
	
	@Column(name = "auth_date", nullable = true,length = 250)
	private LocalDateTime auth_date;

	
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

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	public boolean isTokenCorrect(String token) {
		return (this.token == token);
	}
	
	public void newAuth() {
		newToken();
		newDate();
	}
	public void newDate() {
		setAuth_date(LocalDateTime.now());
	}
	public void newToken() {
		setToken(getRandomStr());
	}
	
	public void erraseToken() {
		setToken("");
	}
	
	/**
	 */
	public void setToken(String token) {
		this.token = token;
	}
	
	private static String getRandomStr()
    {
    	int n = 249;
        //choisissez un caractére au hasard à partir de cette chaîne
        String str = "jrAB£<°5+>CD&éE($"
        		+ "%-F|6èµ_#è§"
        		+ "G^ço"
        		+ "ôîûâêii"
        		+ "iii)=$ù*!:;,7H/8I9J"
        		+ "0K1.LMN2O3P?4"
        		+ "QRSTUVWXYZ"
                + "aJbcdef?ghijkl"
                + "mn/ohhpqrstuÖÏ"
                + "ÜÄËvù.YTQx%yz"; 
  
        StringBuilder s = new StringBuilder(n); 
  
        for (int i = 0; i < n; i++) { 
            int index = (int)(str.length() * Math.random()); 
            s.append(str.charAt(index)); 
        } 
        return s.toString(); 
    }

	/**
	 * @return the auth_date
	 */
	public LocalDateTime getAuth_date() {
		return auth_date;
	}

	/**
	 * @param auth_date the auth_date to set
	 */
	public void setAuth_date(LocalDateTime auth_date) {
		this.auth_date = LocalDateTime.now();
	} 
	
	private LocalDateTime expiredTime() {
		return getAuth_date().plusHours(4);
	}
	
	public boolean isTimePassed() {
		boolean to_return = false;
		LocalDateTime now = LocalDateTime.now();
		LocalDateTime expire = expiredTime();
		if( expire.isBefore(now) ) {
			to_return = true;
		}else {
		    erraseToken();
		}
		return to_return;
	}

	@Override
	public String toString() {
		return "Authentification ["
				+ "  getId()=" 			+ getId() 
				+ ", getUsername()=" 	+ getUsername() 
				+ ", getPassword()="	+ getPassword()
				+ ", getToken()=" 		+ getToken() 
				+ ", getAuth_date()=" 	+ getAuth_date()
				+ ", expiredTime()=" 	+ expiredTime()  
				+ ", isTimePassed()=" 	+ isTimePassed() 
				+ "]";
	}
}
