/**
 * 
 */
package com.catastima.cataseller.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.catastima.cataseller.modal.Seller;
import com.catastima.cataseller.repository.*;

/**
 * @author Ansary MARECAR
 *
 */
@Service
@Transactional
public class ServiceSeller implements ImplService<Seller>  {
	
	@Autowired
    private RepositorySeller repo;

	@Override
	public void insert(Seller elem) {
		// TODO Auto-generated method stub
		repo.save(elem);

	}

	@Override
	public void insertList(List<Seller> elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller elem) {
		// TODO Auto-generated method stub
		repo.save(elem);

	}

	@Override
	public List<Seller> getAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Seller getElemById(Long elem_id) {
		// TODO Auto-generated method stub
		return repo.findById(elem_id).get();
	}

	@Override
	public void delete(long elem_id) {
		// TODO Auto-generated method stub
		repo.deleteById(elem_id);

	}

	@Override
	public Seller save(Seller elem) {
		// TODO Auto-generated method stub
		return repo.save(elem);
	}

}
