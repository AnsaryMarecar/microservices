/**
 * 
 */
package com.catastima.home.proxies;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.ProductBean;

import java.util.List;
/**
 * @author Ansary MARECAR
 *
 */

@FeignClient(name = "microservice-products", url = "product:9001")
public interface MicroServiceProxyProduct {
	@GetMapping(value = "/map/products")
	List<ProductBean> listProducts();

	@GetMapping( value = "/map/products/{seller_id}")
	List<ProductBean> TakeProductShop(@PathVariable("seller_id") Long seller_id);
	
	@GetMapping( value = "/map/products/category/{id}")
	List<ProductBean> TakeProductCategory(@PathVariable("id") Long id);
	
	@GetMapping( value = "/map/products/product_id/{product_id}")
	ProductBean TakeProduct(@PathVariable("product_id") Long product_id);
	
	@GetMapping( value = "/map/products/{seller_id}/{category_id}")
	List<ProductBean> TakeProductShopCategory(@PathVariable("seller_id") Long seller_id,@PathVariable("category_id") Long category_id);
	
	@GetMapping( value = "/map/product/{seller_id}/{category_id}")
	List<ProductBean> TakeProductShopCategories(@PathVariable("seller_id") Long seller_id,@PathVariable("category_id") List<Long> category_id);
	
	@RequestMapping(method = RequestMethod.POST, value = "/map/products/add", consumes = "application/json")
	ProductBean add(ProductBean product);
	
	@RequestMapping(method = RequestMethod.PUT, value = "/map/products/update", consumes = "application/json")
	ProductBean update(ProductBean product);
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/map/products/delete/{id}", consumes = "application/json")
	ProductBean delete(@PathVariable("id") Long id);
	
}