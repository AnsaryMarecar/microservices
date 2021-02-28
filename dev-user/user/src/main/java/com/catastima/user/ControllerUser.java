/**
 * 
 */
package com.catastima.user;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Ansary MARECAR
 *
 */
@RestController
public class ControllerUser {
	@Autowired
    private ServiceUser service;
    
    
/**
 * @throws Exception   **/ 
  
    // Affiche la liste de tous les produits disponibles
    @GetMapping(value = "/map/users")
    public List<User> listAll() throws Exception{
        List<User> elem = service.getAll();
        if(elem.isEmpty()) throw new Exception("Not available");
        return elem;
    }

 
    //Récuperer une categorie par son id
    @PostMapping( value = "/map/users/one")
    public ResponseEntity<User> listOne(@RequestBody  Long id) {
    	User elem = service.getElemById(id);
    	if(elem==null) {
    		System.out.println("cannot find");
    		elem = new User((long)1,"error","error");
    	}else {
    		System.out.println("find "+elem.getUser_name());
    		
    	}
    	//return elem;
    	return new ResponseEntity<User>(elem, HttpStatus.CREATED);
    }
    
    @DeleteMapping (value = "/map/users/delete/{id}")
    public void delete(@PathVariable int id){
    	service.delete(id);
    }
    
    @PostMapping( value = "/map/users/add")
    public ResponseEntity<User> add(@RequestBody User elem) throws Exception{
    	User new_elem = service.save(elem);
    	if(new_elem == null) throw new Exception("Cannot add");
        return new ResponseEntity<User>(new_elem, HttpStatus.CREATED);
    }
    
    @PutMapping( value = "/map/users/update")
    public ResponseEntity<User> update(@RequestBody User elem) throws Exception{
    	User new_elem = service.save(elem);
    	if(new_elem == null) throw new Exception("Cannot edit");
        return new ResponseEntity<User>(new_elem, HttpStatus.CREATED);
    }
}
