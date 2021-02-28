package com.catastima.home.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.catastima.home.bean.Authentification;
import com.catastima.home.bean.User;
import com.catastima.home.bean.Login;
import com.catastima.home.proxies.ProxyAuthentification;
import com.catastima.home.proxies.ProxyUser;

@Controller
public class AuthentificationController {
	
	@Autowired
	private ProxyAuthentification Proxy;
	
	@Autowired
	private ProxyUser ProxyUser;
	
	//page access
	@RequestMapping("/authentification/newconnect")
    public String viewNew(Model model) {
		Authentification elem = new Authentification();
    	model.addAttribute("authentification", elem);
        return "newconnect";
    }
	
	@RequestMapping("/authentification/connected")
    public String viewConnected(Model model, HttpSession session) {
		String username = (String)session.getAttribute("username");
		model.addAttribute("username", username);
        return "connected";
    }
	
	//connection
	@RequestMapping(value = "/authentification/connect", method = RequestMethod.POST)
    public String connect(@ModelAttribute("authentification") Authentification elem, HttpServletRequest request) {

    		Authentification auth = Proxy.connect(elem); 
    		if(auth.getId()==null || auth.getToken()==null) {
    		}
    		else {
	    		
    			Login.getInstance(auth);
    			System.out.println("auth.getUser_id() : "+ auth.getUser_id());
    			//String u = ProxyUser.TakeOne(auth.getUser_id());
    			User u = ProxyUser.TakeOne(auth.getUser_id());
    			if(u==null) {
    				System.out.println("problem connexion");
    				request.getSession().setAttribute("user_name", "name ");
    	    		request.getSession().setAttribute("user_surname", "surname ");
    			}
    			else {
    				System.out.println("name : "+u.getUser_name()+" surname: "+u.getUser_surname());
    				request.getSession().setAttribute("user_name", u.getUser_name());
    	    		request.getSession().setAttribute("user_surname", u.getUser_surname());
    			}
				System.out.println(Login.getLogin().toString());
	    		request.getSession().setAttribute("user_id", auth.getUser_id());
	    		request.getSession().setAttribute("username", auth.getUsername());
	    		request.getSession().setAttribute("id", auth.getId());
	    		request.getSession().setAttribute("token", auth.getToken());
	    		request.getSession().setAttribute("auth_date", auth.getAuth_date());
	    		return "redirect:/authentification/connected";
    		}
    	return "redirect:/authentification/newconnect";
    }
	
	/**
	@RequestMapping(value = "/authentification/isConnected", method = RequestMethod.POST)
    public String isConnected(@ModelAttribute("authentification") Authentification elem) {
    	String to_return = Proxy.isPresent(elem);
    	if("present"==to_return) {
    		Authentification auth = Proxy.connect(elem); 
    		return "redirect:/authentification/connected";
    	}
    	else {
    		return "redirect:/authentification/newconnect";
    	}
    }**/
	
	//inscription connection
/**	@RequestMapping(value = "/authentification/newauthentification", method = RequestMethod.POST)
    public String inscription(@ModelAttribute("authentification") Authentification elem) {
		String to_return = Proxy.isPresent(elem);
    	if("present"==to_return) {
    		return "redirect:/authentification/inscription";
    	}
    	else {
    		Proxy.add(elem); 
    		return "redirect:/authentification/newconnect";
    	}
    }
	**/
	//disconnection
	@RequestMapping(value = "/authentification/disconnect", method = RequestMethod.POST)
	public String disconnect(@ModelAttribute("authentification") Authentification elem, HttpServletRequest request) {
	   Proxy.disconnect(elem);  
	   Login.disconnect();
	   request.getSession().invalidate();
	   return "redirect:/authentification/newconnect";
	}	
}
