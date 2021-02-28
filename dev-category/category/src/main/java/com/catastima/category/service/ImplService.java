/**
 * 
 */
package com.catastima.category.service;

import java.util.List;

public interface ImplService<T> {
	public void insert(T elem);
	public T save(T elem);
	public void insertList(List<T> elem);
	public void update(T elem); 
	public List<T> getAll();
	public T getElemById(Long elem_id); 
    public void delete(long elem_id);
	public List<T> getParent(T elem);
	public List<Long> getChild(Long elem);
}

