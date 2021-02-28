package com.catastima.home.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.Category;
@FeignClient(name = "microservice-categories", url = "localhost:9002")
public interface ProxyCategory {
	@GetMapping(value = "/map/categories")
	List<Category> listAll();
	
	@GetMapping(value = "/map/category/{id}")
	List<Long> listAll(@PathVariable("id") Long id);

	@GetMapping( value = "/map/categories/{id}")
	Category TakeOne(@PathVariable("id") Long id);
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/categories/add", consumes = "application/json")
	Category add(Category product);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/categories/update", consumes = "application/json")
	Category update(Category product);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/map/categories/delete/{id}", consumes = "application/json")
	Category delete(@PathVariable("id") Long id);
	
}
