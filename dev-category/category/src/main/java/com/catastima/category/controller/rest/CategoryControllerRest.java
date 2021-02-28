/**
 * 
 */
package com.catastima.category.controller.rest;

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

import com.catastima.category.model.Category;
import com.catastima.category.service.ServiceCategory;


@RestController
public class CategoryControllerRest {
	@Autowired
    private ServiceCategory service;
    
    
/**
 * @throws Exception   **/ 
  
    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/map/categories")
    public List<Category> listAll() throws Exception{
        List<Category> categories = service.getAll();
        if(categories.isEmpty()) throw new Exception("Aucune categorie n'est disponible");
        return categories;
    }

 // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/map/category/{id}")
    public List<Long> listAll(@PathVariable Long id) throws Exception{
        List<Long> categories = service.getChild(id);
        if(categories.isEmpty()) throw new Exception("Aucune categorie n'est disponible");
        return categories;
    }
    
    //Récuperer une categorie par son id
    @GetMapping( value = "/map/categories/{id}")
    public Category listOne(@PathVariable Long id) {
    	Category category = service.getElemById(id);
        //if(!category.isPresent())  throw new Exception("La categorie correspondant à l'id " + id + " n'existe pas");
        return category;
    }
    
    @DeleteMapping (value = "/map/categories/delete/{id}")
    public void delete(@PathVariable int id) /**throws Exception**/ {
    	/**if(!serviceCategory.isPresent(id))  
        	throw new Exception("L'élément correspondant à l'id " + id + " n'existe pas");
        else**/
    	service.delete(id);
    }
    
    @PostMapping( value = "/map/categories/add")
    public ResponseEntity<Category> add(@RequestBody Category elem) throws Exception{
    	Category new_elem = service.save(elem);
    	if(new_elem == null) throw new Exception("Impossible d'ajouter le produit");
        return new ResponseEntity<Category>(elem, HttpStatus.CREATED);
    }
    
    @PutMapping( value = "/map/categories/update")
    public void update(@RequestBody Category category) /**throws Exception **/{
    	/**
    	if(!serviceCategory.isPresent(product.getProduct_id()))  
        	throw new Exception("L'élément correspondante à l'id: " + category.getCategory_id() + " n'existe pas");
        else**/
    	service.save(category);
    }
}
