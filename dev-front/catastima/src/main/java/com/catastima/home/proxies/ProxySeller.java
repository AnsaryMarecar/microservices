package com.catastima.home.proxies;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.Seller;

@FeignClient(name = "microservice-sellers", url = "seller:9003")
public interface ProxySeller {
	@GetMapping(value = "/map/sellers")
	List<Seller> listAll();

	@GetMapping( value = "/map/sellers/{id}")
	Seller TakeOne(@PathVariable("id") Long id);
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/sellers/add", consumes = "application/json")
	Seller add(Seller seller);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/sellers/update", consumes = "application/json")
	Seller update(Seller seller);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/map/sellers/delete/{id}", consumes = "application/json")
	Seller delete(@PathVariable("id") Long id);
	
}
