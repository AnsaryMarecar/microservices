/**
 * 
 */
package com.catastima.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "product")
public class Product {
	private Long product_id;
	private String product_name;
	private double product_price;
	private String product_quantity;
	private Long category_id;
	private Long seller_id;
	private String product_image;
	private int	  product_stock;
	
	/**
	 * 
	 */
	public Product() {
		this.product_stock = 0;
	}
	/**
	 * @param product_id
	 * @param product_name
	 * @param product_price
	 * @param product_quantity
	 * @param category_id
	 * @param seller_id
	 * @param product_image
	 * @param product_stock
	 */
	public Product(Long product_id, String product_name,  String product_quantity, double product_price, Long category_id,
			Long seller_id,String product_image, int product_stock) {
		this.product_id = product_id;
		this.product_name = product_name;
		this.product_price = product_price;
		this.product_quantity = product_quantity;
		this.category_id = category_id;
		this.seller_id = seller_id;
		this.product_image = product_image;
		this.product_stock = product_stock;
	}

	/**
	 * @param product_name
	 */
	public Product(String product_name) {
		this.product_name = product_name;
	}

	/**
	 * @return the product_id
	 */
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getProduct_id() {
		return product_id;
	}
	/**
	 * @param product_id the product_id to set
	 */
	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}
	/**
	 * @return the product_name
	 */
	@Column(nullable = false, length = 250)
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the product_price
	 */
	@Column(nullable = false)
	public double getProduct_price() {
		return product_price;
	}
	/**
	 * @param product_price the product_price to set
	 */
	public void setProduct_price(double product_price) {
		this.product_price = product_price;
	}
	/**
	 * @return the product_quantity
	 */
	@Column(nullable = false)
	public String getProduct_quantity() {
		return product_quantity;
	}
	/**
	 * @param product_quantity the product_quantity to set
	 */
	public void setProduct_quantity(String product_quantity) {
		this.product_quantity = product_quantity;
	}
	/**
	 * @return the category_id
	 */
	@Column(nullable = false)
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
	 * @return the seller_id
	 */
	@Column(nullable = false)
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
	 * @return the product_image
	 */
	@Column(nullable = true)
	public String getProduct_image() {
		return product_image;
	}
	/**
	 * @param product_image the product_image to set
	 */
	public void setProduct_image(String product_image) {
		this.product_image = product_image;
	}
	/**
	 * @return the product_stock
	 */
	@Column(nullable = true)
	public int getProduct_stock() {
		return product_stock;
	}
	/**
	 * @param product_stock the product_stock to set
	 */
	@Column(nullable = false)
	public void setProduct_stock(int product_stock) {
		this.product_stock = product_stock;
	}
	@Override
	public String toString() {
		return "Product [getProduct_id()=" + getProduct_id() 
				+ ", getProduct_name()=" + getProduct_name()
				+ ", getProduct_price()=" + getProduct_price() 
				+ ", getProduct_quantity()=" + getProduct_quantity()
				+ ", getCategory_id()=" + getCategory_id() 
				+ ", getSeller_id()=" + getSeller_id()
				+ ", getProduct_image()=" + getProduct_image() 
				+ ", getProduct_stock()=" + getProduct_stock() 
				+ "]";
	}
	
	
	
	
}
