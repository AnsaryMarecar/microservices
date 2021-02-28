/**
 * 
 */
package com.catastima.category.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catastima.category.model.Category;
import com.catastima.category.repository.*;


@Service
@Transactional
public class ServiceCategory implements ImplService<Category> {
	
	 @Autowired
	    private RepositoryCategory repo;
	 
	@Override
	public void insert(Category elem) {
		// TODO Auto-generated method stub
		repo.save(elem);

	}

	@Override
	public void insertList(List<Category> elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Category elem) {
		// TODO Auto-generated method stub
		repo.save(elem);

	}

	@Override
	public List<Category> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();

	}

	@Override
	public Category getElemById(Long elem_id) {
		// TODO Auto-generated method stub
		return repo.findById(elem_id).get();
	}
	
	@SuppressWarnings("null")
	@Override
	public List <Category> getParent(Category c) {
		// TODO Auto-generated method stub
		List<Category> list = null;
		
		while( c.getCategory_parent() != null) {
			c = getElemById(c.getCategory_parent());
			list.add(c);
		}
		return list;
	}
	
	@Override
	public List<Long> getChild(Long c) {
		// TODO Auto-generated method stub
		List<Long> fulllist = null;
		List<Long> list = null;
		if( c != null) {
			list = repo.findParent(c);
			if(list !=null){
				fulllist = list;
			}
		}
		return fulllist;
	}

	@Override
	public void delete(long elem_id) {
		// TODO Auto-generated method stub
		repo.deleteById(elem_id);

	}

	@Override
	public Category save(Category elem) {
		// TODO Auto-generated method stub
		return repo.save(elem);
	}

}
