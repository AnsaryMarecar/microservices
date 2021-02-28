/**
 * 
 */
package com.catastima.home.bean;

import java.time.LocalDateTime;

/**
 * @author Ansary MARECAR
 *
 */
public final class Login {
	 private static Login 	instance;
	 private String 		username;
	 private LocalDateTime 	auth_date;
	 private String 		token;

	private Login(Authentification auth) {
        // The following code emulates slow initialization.
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        this.username 	= auth.getUsername();
        this.token 		= auth.getToken();
        this.auth_date 	= auth.getAuth_date();
        System.out.println("emulated");
	}
	
	public static Login getInstance(Authentification auth) {
        if (instance == null) {
            instance = new Login(auth);
        }else {
        	instance.setUsername(auth.getUsername());
        	instance.setAuth_date(auth.getAuth_date());
        	instance.setToken(auth.getToken());
        }
        
        return instance;
    }
	
	public static void disconnect() {
		instance = null;
    }
	
	public static Login getLogin() {
		return instance;
	}
	
	private static LocalDateTime expiredTime() {
		if(instance!=null) {
			return instance.getAuth_date().plusHours(4);
		}
		else {
			return null;
		}
	}
	
	public static boolean isTimePassed() {
		boolean to_return = false;
		if(instance!=null) {
			LocalDateTime now = LocalDateTime.now();
			LocalDateTime expire = expiredTime();
			if( expire.isBefore(now) ) {
				to_return = true;
			}else {
				System.out.println("time is up");
				disconnect();
			}
		}else {
			System.out.println("not connected");
		}
		return to_return;
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
	private void setUsername(String username) {
		this.username = username;
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
	private void setAuth_date(LocalDateTime auth_date) {
		this.auth_date = auth_date;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	private void setToken(String token) {
		this.token = token;
	}

	public String toString() {
		return "Login ["
		+ "getUsername()=" + instance.getUsername() 
		+ ", getAuth_date()=" + instance.getAuth_date() 
		+ ", getToken()="+ instance.getToken() 
		+ "]";
	}

	
}
