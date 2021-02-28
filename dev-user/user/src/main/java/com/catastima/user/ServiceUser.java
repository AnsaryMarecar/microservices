/**
 * 
 */
package com.catastima.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Ansary MARECAR
 *
 */
@Service
@Transactional
public class ServiceUser implements ImplService<User> {
	@Autowired
	RepositoryUser repo;
	
	@Override
	public void insert(User elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public User save(User elem) {
		// TODO Auto-generated method stub
		return repo.save(elem);
	}

	@Override
	public void insertList(List<User> elem) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User elem) {
		// TODO Auto-generated method stub
		repo.save(elem);
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public User getElemById(Long elem_id) {
		// TODO Auto-generated method stub
		return repo.findById(elem_id).get();
	}

	@Override
	public void delete(long elem_id) {
		// TODO Auto-generated method stub
		repo.deleteById(elem_id);
	}

}
