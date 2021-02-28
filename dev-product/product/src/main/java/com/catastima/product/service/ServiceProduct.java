package com.catastima.product.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.catastima.product.model.Product;
import com.catastima.product.repository.RepositoryProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class ServiceProduct implements ImplService<Product> {
	
	@Autowired
    private RepositoryProduct repoProduct;
	
	
	@Override
	public void insert(Product elem) {
		// TODO Auto-generated method stub
		repoProduct.save(elem);
	}

	@Override
	public void insertList(List<Product> elem) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Product elem) {
		// TODO Auto-generated method stub
		repoProduct.save(elem);
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return repoProduct.findAll();
	}

	@Override
	public Product getElemById(long elem_id) {
		// TODO Auto-generated method stub
		return repoProduct.findById(elem_id).get();
	}
	
	@Override
	public void delete(long elem_id) {
		repoProduct.deleteById(elem_id);
	}

	public static List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isPresent(long elem_id) {
		// TODO Auto-generated method stub
		return repoProduct.existsById(elem_id);
	}

	@Override
	public Product save(Product elem) {
		// TODO Auto-generated method stub
		return repoProduct.save(elem);
	}

	@Override
	public List<Product> getAll(Long seller_id) {
		// TODO Auto-generated method stub
		return repoProduct.findAll(seller_id);
	}

	@Override
	public List<Product> getAll(Long seller_id, Long category_id) {
		// TODO Auto-generated method stub
		return repoProduct.findAll(seller_id,category_id);
	}

	@Override
	public List<Product> getAll(List<Long> elem) {
		// TODO Auto-generated method stub
		List<Product> listfull = null;
		List<Product> listcurrent = null;
		for(int i = 0 ; i < elem.size() ; i++) {
			listcurrent = repoProduct.findAll(elem.get(i));
			if(listcurrent !=null) {
				listfull = Stream.concat(listfull.stream(), listcurrent.stream())
	                    .collect(Collectors.toList());
			}
		}
		return listfull;
	}

	@Override
	public List<Product> getAllList(long seller_id, List<Long> elem) {
		// TODO Auto-generated method stub
		List<Product> listfull = null;
		List<Product> listcurrent = null;
		for(int i = 0 ; i < elem.size() ; i++) {
			listcurrent = repoProduct.findAll(seller_id,elem.get(i));
			
			if(listcurrent !=null) {
				if(i == 0) {
					listfull = listcurrent;
				}
				else {
				listfull = Stream.concat(listfull.stream(), listcurrent.stream())
	                    .collect(Collectors.toList());
			
				}
			}
		}
		return listfull;
	}


}
