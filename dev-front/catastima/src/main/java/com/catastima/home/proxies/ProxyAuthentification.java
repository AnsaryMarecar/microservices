package com.catastima.home.proxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.Authentification;
import com.catastima.home.bean.User;

@FeignClient(name = "microservice-authentifications", url = "authentification:9005")
public interface ProxyAuthentification {
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/authentifications/add", consumes = "application/json")
	Authentification add(Authentification auth);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/authentifications/disconnect", consumes = "application/json")
	Authentification disconnect(Authentification auth);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/authentifications/connect", consumes = "application/json")
	Authentification connect(Authentification auth);
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/authentifications/isConnected", consumes = "application/json")
	String isConnected(Authentification auth);
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/authentifications/isPresent", consumes = "application/json")
	String isPresent(Authentification auth);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/authentifications/update", consumes = "application/json")
	User update(Authentification auth);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/map/authentifications/delete/{id}", consumes = "application/json")
	Authentification delete(@PathVariable("id") Long id);	
}
