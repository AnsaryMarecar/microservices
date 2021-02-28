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

import com.catastima.home.bean.Login;
import com.catastima.home.bean.Seller;
import com.catastima.home.proxies.ProxyAuthentification;
import com.catastima.home.proxies.ProxySeller;

@Controller
public class SellerController {

    @Autowired
    private ProxySeller Proxy;
    
    @RequestMapping("/seller")
    public String viewAll(Model model) {
    	 List<Seller> listElems = Proxy.listAll();
        model.addAttribute("listSellers", listElems);
        return "seller";
    }
  
    //page product (with data)
    @SuppressWarnings("null")
	@RequestMapping("/seller/{id}")
    public String viewOne(Model model, @PathVariable(name = "seller_id") Long id) {
    	Seller elem = Proxy.TakeOne(id);
    	List<Seller> listElems = null;
    	listElems.add(elem);
    	model.addAttribute("listSellers", listElems);
        return "seller";
    }
    
    //page add product (without data)
    @RequestMapping("/seller/newseller")
    public String viewNew(Model model, HttpSession session) {
	    	String user_name = (String)session.getAttribute("user_name")+" "+(String)session.getAttribute("user_surname");
	    	if(user_name != null) {
	    		Seller elem = new Seller();
	    		long id = (long)session.getAttribute("user_id");
	    		elem.setUser_id(id);
	    		model.addAttribute("seller", elem);
	    		model.addAttribute("username", user_name);
	        	return "newseller";
	    	}
	    	return "redirect:/seller";
    }
    
    
    
    //page edit product (with data, without saving) //
    @RequestMapping("/seller/edit/{seller_id}")
    public String viewEdit(
    			Model model
    		, 	@PathVariable(name = "seller_id") Long id
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("user_name")+" "+(String)session.getAttribute("user_surname");
    	if(username != null) {
    		Seller elem = Proxy.TakeOne(id);
    		Long user_id = (long)session.getAttribute("user_id");
    		if( elem.getUser_id() == user_id) {
    			model.addAttribute("seller",elem);
    			return "editseller";
    		}
    	}
    	return "redirect:/seller";
    }
    
    @RequestMapping(value = "/seller/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("seller") Seller elem,  HttpSession session) {
    	String username = (String)session.getAttribute("user_name")+" "+(String)session.getAttribute("user_surname");
    	if(username != null) {
    		Long user_id = (long)session.getAttribute("user_id");
    		elem.setUser_id(user_id);
    		Proxy.add(elem);
    	}
    	return "redirect:/seller";
    	
    }
    
    @RequestMapping(value = "/seller/editsave", method = RequestMethod.POST)
    public String edit(
    		 @ModelAttribute("seller") Seller elem
    		, HttpSession session) {
    	String username = (String)session.getAttribute("user_name")+" "+(String)session.getAttribute("user_surname");
    	if(username != null) {
    		Long user_id = (long)session.getAttribute("user_id");
    		elem.setUser_id(user_id);
    		Proxy.update(elem);  
    	}
        return "redirect:/seller";
    }

    @RequestMapping("/seller/delete/{seller_id}")
    public String delete(@PathVariable(name = "seller_id") Long id,  HttpSession session) {
    	String username = (String)session.getAttribute("user_name")+" "+(String)session.getAttribute("user_surname");
    	if(username != null) {
    		Proxy.delete(id);
    	}
        return "redirect:/seller";       
    }
}
