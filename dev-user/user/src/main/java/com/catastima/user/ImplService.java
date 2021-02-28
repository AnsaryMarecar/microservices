/**
 * 
 */
package com.catastima.user;

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
	public T getElemById(Long elem_id); 
    public void delete(long elem_id);
}
