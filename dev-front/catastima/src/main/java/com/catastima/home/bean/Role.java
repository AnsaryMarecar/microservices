package com.catastima.home.bean;

public class Role {
	private Long role_id;
	private String role_name;

	/**
	 * @param role_id
	 * @param role_name
	 */
	public Role(Long role_id, String role_name) {
		this.role_id = role_id;
		this.role_name = role_name;
	}

	/**
	 * 
	 */
	public Role() {
	}

	/**
	 * @return the role_id
	 */
	public Long getRole_id() {
		return role_id;
	}

	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	@Override
	public String toString() {
		return "Role [getRole_id()=" + getRole_id() + ", getRole_name()=" + getRole_name() + "]";
	}
}
