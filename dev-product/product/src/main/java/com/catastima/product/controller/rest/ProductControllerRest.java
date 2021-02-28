/**
 * 
 */
package com.catastima.product.controller.rest;

/**
 * @author Ansary MARECAR
 *
 */


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catastima.product.model.Product;
import com.catastima.product.service.ServiceProduct;


/**
 * @author Ansary MARECAR
 *
 */
@RestController
public class ProductControllerRest{

    @Autowired
    private ServiceProduct serviceProduct;
    
    
/**
 * @throws Exception   **/ 
  
    // all product 
    @GetMapping(value = "/map/products")
    public List<Product> listProduct() throws Exception{
        List<Product> products = serviceProduct.getAll();
        if(products.isEmpty()) throw new Exception("Product are not available");
        return products;
    }
    
    // all product by seller
    @GetMapping(value = "/map/products/{seller_id}")
    public List<Product> listProductBySeller(
    		@PathVariable(name = "seller_id") Long id
    		) throws Exception{
        List<Product> products = serviceProduct.getAll(id);
        for(int i = 0 ; i <products.size(); i++) {
        	System.out.println(  products.get(i).toString());
        }
        if(products.isEmpty()) throw new Exception("Product are not available");
        return products;
    }
    
    
    // all product by seller and category
    @GetMapping(value = "/map/product/{seller_id}/{category_id}")
    public List<Product> listProductBySellerCategory(
    			@PathVariable(name = "seller_id") Long seller_id
    		,	@PathVariable(name = "category_id") List<Long> category_id
    		) throws Exception{
    	
    	
    	List<Product> products = serviceProduct.getAllList(seller_id,category_id);
    	for(int i = 0; i<products.size();i++) {
    		System.out.println("\n i: "+products.get(i).getProduct_name());
    	}
        if(products.isEmpty()) throw new Exception("Product are not available");
        return products;
    }
    
    
    
    //take a product by id
    @GetMapping( value = "/map/products/product_id/{id}")
    public Product takeAProduct(@PathVariable Long id) throws Exception {
    	Product product = null;
        if(!serviceProduct.isPresent(id))  
        	throw new Exception("The product id: " + id + " does not exist");
        else
        	product = serviceProduct.getElemById(id);
        return product;
    }
    
    @DeleteMapping (value = "/map/products/delete/{id}")
    public void deleteProduct(@PathVariable int id){
        	serviceProduct.delete(id);
    }
    
    @PostMapping( value = "/map/products/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) throws Exception{
    	Product new_product = serviceProduct.save(product);
    	if(new_product == null) throw new Exception("Exception: cannot add product");
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
    
    @PutMapping( value = "/map/products/update")
    public void updateProduct(@RequestBody Product product){
        serviceProduct.save(product);
    }
}