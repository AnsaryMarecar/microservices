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

import com.catastima.home.bean.Category;
import com.catastima.home.proxies.ProxyCategory;

@Controller
public class CategoryController {

    @Autowired
    private ProxyCategory Proxy;
    
    @RequestMapping("/category")
    public String viewAll(Model model) {
    	 List<Category> listElems = Proxy.listAll();
        model.addAttribute("listCategories", listElems);
        return "category";
    }
  
    //page product (with data)
    @SuppressWarnings("null")
	@RequestMapping("/category/{id}")
    public String viewOne(Model model, @PathVariable(name = "category_id") Long id) {
    	Category elem = Proxy.TakeOne(id);
    	List<Category> listElems = null;
    	listElems.add(elem);  
    	model.addAttribute("listCategories", listElems);
        return "category";
    }
    
    //page add category (without data)
    @RequestMapping("/category/newcategory")
    public String viewNew(
    			Model model
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		Category elem = new Category();
    		model.addAttribute("category", elem);
        	return "newcategory";
    	}
    	return "redirect:/category";
    }
    
    //page edit product (with data, without saving) //
    @RequestMapping("/category/edit/{category_id}")
    public String viewEdit(
    			Model model
    		,	@PathVariable(name = "category_id") Long id
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		Category elem = Proxy.TakeOne(id);  
    		model.addAttribute("category", elem);
            return "editcategory";  
    	}
    	return "redirect:/category";
    }
    
    @RequestMapping(value = "/category/save", method = RequestMethod.POST)
    public String save(
    			@ModelAttribute("category") Category elem
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		Proxy.add(elem);  
    	}
        return "redirect:/category";
    }
    
    @RequestMapping(value = "/category/editsave", method = RequestMethod.POST)
    public String edit(
    			@ModelAttribute("category") Category elem
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		Proxy.update(elem);
    	}
        return "redirect:/category";
    }

    @RequestMapping("/category/delete/{category_id}")
    public String delete(
    		@PathVariable(name = "category_id") Long id
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		Proxy.delete(id);
    	}
        return "redirect:/category";       
    }
}