package com.catastima.authentification.service;

import com.catastima.authentification.bean.Authentification;

public interface ImplService<T>  {
	//public Authentification findByUsername(String username);
	//public UserDetails loadUserByUsername(String username);
	//public void insert(T elem);
	public void delete(long elem_id);
	//boolean isPresent(long elem_id);
	//public void update(T elem);
	public T save(T elem);
	public boolean isPresent(Authentification ath);
	public T connect(Authentification ath);
	public void disconnect(Authentification ath);
	boolean isConnected(Authentification ath);
}
