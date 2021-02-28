package com.catastima.home.bean;

/**

 * @author FREEZY
 *
 */
public class Seller {
	private Long seller_id;
	private String seller_name;
	private Long user_id;
	
	/**
	 * 
	 */
	public Seller() {
	}
	 /* */
	 /* */
	 /* */
	public Seller(Long seller_id, String seller_name, Long user_id) {
		this.seller_id = seller_id;
		this.seller_name = seller_name;
		this.user_id = user_id;
	}
	/**
	 * @param seller_name
	 */
	public Seller(String seller_name) {
		this.seller_name = seller_name;
	}
	/**
	 * @return the seller_id
	 */
	public Long getSeller_id() {
		return seller_id;
	}
	/**
	 * @param seller_id the seller_id to set
	 */
	public void setSeller_id(Long seller_id) {
		this.seller_id = seller_id;
	}
	/**
	 * @return the seller_name
	 */
	public String getSeller_name() {
		return seller_name;
	}
	/**
	 * @param seller_name the seller_name to set
	 */
	public void setSeller_name(String seller_name) {
		this.seller_name = seller_name;
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
