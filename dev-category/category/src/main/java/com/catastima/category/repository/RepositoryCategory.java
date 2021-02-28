/**
 * 
 */
package com.catastima.category.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.catastima.category.model.Category;


public interface RepositoryCategory extends JpaRepository<Category, Long> {

	@Query(value = "select c.category_id from Category c where c.category_parent = ?1")
	public List<Long> findParent(Long category_id);	
}
