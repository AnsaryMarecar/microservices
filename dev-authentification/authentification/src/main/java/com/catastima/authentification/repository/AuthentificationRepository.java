/**
 * 
 */
package com.catastima.authentification.repository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

import com.catastima.authentification.bean.*;

/**
 * @author Ansary MARECAR
 *
 */
public interface AuthentificationRepository extends JpaRepository<Authentification,Long> {
	@Query("select a from Authentification a where a.username = ?1 and a.password = ?2")
	public Authentification findByUsername(String username, String password);
	
	@Query(value = "select count(*) from authentification a where a.username = ?1 and a.password = ?2",nativeQuery = true)
	public int countnb(String username, String password);
}