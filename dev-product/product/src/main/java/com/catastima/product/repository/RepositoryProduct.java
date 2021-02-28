package com.catastima.product.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.catastima.product.model.Product;

public interface RepositoryProduct extends JpaRepository<Product, Long> {
	@Query(value = "select p from Product p where p.seller_id = ?1 and p.category_id = ?2 ")
	public List<Product> findAll(Long seller_id, Long category_id);
	
	@Query(value = "select p from Product p where p.seller_id = ?1")
	public List<Product> findAll(Long seller_id);
}