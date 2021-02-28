/**
 * 
 */
package com.catastima.home.bean;

public class Category {
	private Long category_id;
	private String category_name;
	private Long category_parent;
	/**
	 * @param category_id
	 * @param category_name
	 * @param category_parent
	 */
	public Category(Long category_id, String category_name, Long category_parent) {
		this.category_id = category_id;
		this.category_name = category_name;
		this.category_parent = category_parent;
	}
	/**
	 * @param category_name
	 */
	public Category(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * 
	 */
	public Category() {
	}
	/**
	 * @return the category_id
	 */
	public Long getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Long category_id) {
		this.category_id = category_id;
	}
	/**
	 * @return the category_name
	 */
	public String getCategory_name() {
		return category_name;
	}
	/**
	 * @param category_name the category_name to set
	 */
	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	/**
	 * @return the category_parent
	 */
	public Long getCategory_parent() {
		return category_parent;
	}
	/**
	 * @param category_parent the category_parent to set
	 */
	public void setCategory_parent(Long category_parent) {
		this.category_parent = category_parent;
	}
	
}
