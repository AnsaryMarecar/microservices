/**
 * 
 */
package com.catastima.home.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.catastima.home.bean.Authentification;
import com.catastima.home.bean.User;
import com.catastima.home.proxies.ProxyAuthentification;
import com.catastima.home.proxies.ProxyUser;

/**
 * @author Ansary MARECAR
 *
 */
@Controller
public class UserController {
    @Autowired
    private ProxyUser Proxy;
    @Autowired
    private ProxyAuthentification proxyAuth;
    
    @RequestMapping("/user")
    public String viewAll(Model model) {
    	 List<User> listElems = Proxy.listAll();
        model.addAttribute("listUsers", listElems);
        return "user";
    }
  
    //page authentification (with data)
    @SuppressWarnings("null")
	@RequestMapping("/user/{id}")
    public String viewOne(Model model, @PathVariable(name = "user_id") Long id) {
    	User elem = Proxy.TakeOne(id);
    	List<User> listElems = null;
    	listElems.add(elem);
    	model.addAttribute("listUsers", listElems);
        return "user";
    }
    
    //page add authentification (without data)
    @RequestMapping("/user/newuser")
    public String viewNew(Model model) {
    	User elem = new User();
    	model.addAttribute("user",elem);
    	System.out.println("gogogo");
        Authentification auth = new Authentification();
        model.addAttribute("authentification",auth);
        
    	return "newuser";
    }
    
    //page edit authentification (with data, without saving) //
    @RequestMapping("/user/edit")
    public ModelAndView viewEdit( HttpSession session) {
    	long id = (long)session.getAttribute("user_id");
    	String username = (String)session.getAttribute("username");
    	Authentification auth = new Authentification(username,"",id);
        ModelAndView mav = new ModelAndView("edituser");
        System.out.println("edit page");
        User elem = Proxy.TakeOne(id);
    	mav.addObject("user", elem);
    	mav.addObject("authentification", auth);
    	return mav;
    }
    
    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("user") User elem, @ModelAttribute("authentification")  Authentification auth) {
    	User u = Proxy.add(elem);
    	auth.setUser_id(u.getUser_id());
    	System.out.println("auth user_id: "+auth.getUser_id());
    	proxyAuth.add(auth);
    	return "redirect:/authentification/newconnect";
    }
    
    @RequestMapping(value = "/user/editsave", method = RequestMethod.POST)
    public String edit(@ModelAttribute("user") User elem, @ModelAttribute("authentification")  Authentification auth, HttpSession session) {
    	long user_id = (long)session.getAttribute("user_id");
    	elem.setUser_id(user_id);
    	Proxy.update(elem);  
    	auth.setUser_id(user_id);
    	auth.setId((long)session.getAttribute("id"));
    	System.out.println("auth user_id: "+auth.getUser_id());
    	proxyAuth.update(auth);
        return "redirect:/authentification/newConnect";
    }

    @RequestMapping("/user/delete/")
    public String delete(HttpSession session) {
    	long user_id = (long)session.getAttribute("user_id");
    	long id = (long)session.getAttribute("id");
    	System.out.println("delete");
    	Proxy.delete(user_id);
    	proxyAuth.delete(id);
        return "redirect:/";       
    }
}
