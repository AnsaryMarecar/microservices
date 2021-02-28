/**
 * 
 */
package com.catastima.cataseller.controller.rest;

import java.util.List;

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

import com.catastima.cataseller.modal.Seller;
import com.catastima.cataseller.service.ServiceSeller;

/**
 * @author Ansary MARECAR
 *
 */
@RestController
public class SellerRestController {
	   @Autowired
	    private ServiceSeller service;
	    
	    
	    /**
	     * @throws Exception   **/ 
	      
	        // Affiche la liste de tous les produits disponibles
	        @GetMapping(value = "/map/sellers")
	        public List<Seller> listAll() throws Exception{
	            List<Seller> elems = service.getAll();
	            if(elems.isEmpty()) throw new Exception("None is available");
	            return elems;
	        }

	        //Récuperer une categorie par son id
	        @GetMapping( value = "/map/sellers/{id}")
	        public Seller listOne(@PathVariable Long id) {
	        	Seller elem = service.getElemById(id);
	            //if(!elem.isPresent())  throw new Exception("id element : " + id + " is not available");
	            return elem;
	        }
	        
	        @DeleteMapping (value = "/map/sellers/delete/{id}")
	        public void delete(@PathVariable int id) /**throws Exception**/ {
	        	/**if(!serviceCategory.isPresent(id))  
	            	throw new Exception("id element : " + id + " is not available");
	            else**/
	        	service.delete(id);
	        }
	        
	        @PostMapping( value = "/map/sellers/add")
	        public ResponseEntity<Seller> add(@RequestBody Seller elem) throws Exception{
	        	Seller new_elem = service.save(elem);
	        	if(new_elem == null) throw new Exception("Cannot add");
	            return new ResponseEntity<Seller>(elem, HttpStatus.CREATED);
	        }
	        
	        @PutMapping( value = "/map/sellers/update")
	        public void update(@RequestBody Seller elem) /**throws Exception **/{
	        	/**
	        	if(!serviceCategory.isPresent(product.getProduct_id()))  
	            	throw new Exception("id element : " + category.getSeller_id() + " is not available");
	            else**/
	        	service.save(elem);
	        }

}
