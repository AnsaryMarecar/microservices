package com.catastima.home.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.User;

@FeignClient(name = "microservice-users", url = "localhost:9004")
public interface ProxyUser {
	@PostMapping(value = "/map/users")
	List<User> listAll(); 

	@RequestMapping(method = RequestMethod.POST, value = "/map/users/one", consumes = "application/json")
	User TakeOne(Long id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/users/add", consumes = "application/json")
	User add(User user);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/users/update", consumes = "application/json")
	User update(User user);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/map/users/delete/{id}", consumes = "application/json")
	User delete(@PathVariable("id") Long id);	
}