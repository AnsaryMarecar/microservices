package com.catastima.product.service;

import java.util.List;
/**
 * @author Ansary MARECAR
 *
 */
public interface ImplService<T> {
	public void insert(T elem);
	public T save(T elem);
	public void insertList(List<T> elem);
	public void update(T elem); 
	public List<T> getAll();
	public List<T> getAll(Long seller_id);
	public List<T> getAll(Long seller_id, Long category_id);
	public T getElemById(long elem_id); 
    public void delete(long elem_id);
    public boolean isPresent(long elem_id);
    public List<T> getAll(List<Long> elem);
    public List<T> getAllList(long seller_id,List<Long> elem);
}
