/**
 * 
 */
package com.catastima.home.bean;
/**
 * @author Ansary MARECAR
 *
 */

public class User {

	private Long user_id;
	private String user_name;
	private String user_surname;
	private String user_adress;
	private String user_cp;
	private String user_city;
	private String user_country;
	/**
	 * @param user_id
	 * @param user_name
	 * @param user_surname
	 * @param user_adress
	 * @param user_cp
	 * @param user_city
	 * @param user_country
	 */
	public User(Long user_id, String user_name, String user_surname, String user_adress, String user_cp,
			String user_city, String user_country) {
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_surname = user_surname;
		this.user_adress = user_adress;
		this.user_cp = user_cp;
		this.user_city = user_city;
		this.user_country = user_country;
	}
	/**
	 * 
	 */
	public User() {
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
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the user_surname
	 */
	public String getUser_surname() {
		return user_surname;
	}
	/**
	 * @param user_surname the user_surname to set
	 */
	public void setUser_surname(String user_surname) {
		this.user_surname = user_surname;
	}
	/**
	 * @return the user_adress
	 */
	public String getUser_adress() {
		return user_adress;
	}
	/**
	 * @param user_adress the user_adress to set
	 */
	public void setUser_adress(String user_adress) {
		this.user_adress = user_adress;
	}
	/**
	 * @return the user_cp
	 */
	public String getUser_cp() {
		return user_cp;
	}
	/**
	 * @param user_cp the user_cp to set
	 */
	public void setUser_cp(String user_cp) {
		this.user_cp = user_cp;
	}
	/**
	 * @return the user_city
	 */
	public String getUser_city() {
		return user_city;
	}
	/**
	 * @param user_city the user_city to set
	 */
	public void setUser_city(String user_city) {
		this.user_city = user_city;
	}
	/**
	 * @return the user_country
	 */
	public String getUser_country() {
		return user_country;
	}
	/**
	 * @param user_country the user_country to set
	 */
	public void setUser_country(String user_country) {
		this.user_country = user_country;
	}
	@Override
	public String toString() {
		return "User [getUser_id()=" + getUser_id() + ", getUser_name()=" + getUser_name() + ", getUser_surname()="
				+ getUser_surname() + ", getUser_adress()=" + getUser_adress() + ", getUser_cp()=" + getUser_cp()
				+ ", getUser_city()=" + getUser_city() + ", getUser_country()=" + getUser_country() + "]";
	}
}
