/**
 * 
 */
package com.catastima.authentification.controller;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.catastima.authentification.service.AuthentificationService;
import com.catastima.authentification.bean.*;

/**
 * @author Ansary MARECAR
 *
 */

@RestController
public class AuthentificationController {
	@Autowired
    private AuthentificationService service;
	
        @DeleteMapping (value = "/map/authentifications/delete/{id}")
        public void delete(@PathVariable int id) {
        	service.delete(id);
        }
        @PostMapping( value = "/map/authentifications/add")
        public ResponseEntity<Authentification> add(@RequestBody Authentification elem) throws Exception{
        	Authentification new_elem = service.save(elem);
        	if(new_elem == null) throw new Exception("Cannot add");
            return new ResponseEntity<Authentification>(elem, HttpStatus.CREATED);
        }
        
        @PostMapping( value = "/map/authentifications/update")
        public ResponseEntity<Authentification> update(@RequestBody Authentification elem) throws Exception{
        	Authentification new_elem = service.save(elem);
        	if(new_elem == null) throw new Exception("Cannot update");
            return new ResponseEntity<Authentification>(elem, HttpStatus.CREATED);
        }
        @PostMapping( value = "/map/authentifications/isConnected")
        public ResponseEntity<String> isConnected(@RequestBody Authentification elem) {
        	String to_return = "not connected";
        	if(service.isConnected(elem)) {
        		to_return = "connected";
        	}
        	return new ResponseEntity<String>(to_return, HttpStatus.CREATED);
        }
        
        @PostMapping( value = "/map/authentifications/isPresent")
        public ResponseEntity<String> isPresent(@RequestBody Authentification elem) {
        	String to_return = "not present";
        	if(service.isPresent(elem)) {
        		to_return = "present";
        	}
        	return new ResponseEntity<String>(to_return, HttpStatus.CREATED);
        }
        
        @PutMapping( value = "/map/authentifications/connect")
        public ResponseEntity<Authentification> connect(@RequestBody Authentification elem){
        	Authentification new_elem = service.connect(elem);
        	return new ResponseEntity<Authentification>(new_elem, HttpStatus.CREATED);
        }
        
        @PutMapping( value = "/map/authentifications/disconnect")
        public void disconect(@RequestBody Authentification elem){
        	service.disconnect(elem);
        }
}