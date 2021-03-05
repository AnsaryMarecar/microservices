package com.catastima.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

import com.catastima.product.model.Product;
import com.catastima.product.service.ServiceProduct;


/**
 * @author Ansary MARECAR
 *
 */
@Controller
public class ProductController {

	
    @Autowired
    private ServiceProduct serviceProduct;
    
    
    @RequestMapping("/product")
    public String viewProductPage(Model model) {
        List<Product> listProducts= serviceProduct.getAll();
        model.addAttribute("listProducts", listProducts);
        return "product";
    }
    
    /**
    @RequestMapping("/product/newproduct")
    public String viewNewProductPage(Model model) {
    	 Product product = new Product();
    	    model.addAttribute("product", product);
        return "newproduct";
    }
    
    
    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {
        serviceProduct.insert(product);  
        return "redirect:/product";
    }
    
    @RequestMapping("/product/edit/{product_id}")
    public ModelAndView viewEditProductPage(@PathVariable(name = "product_id") Long id) {
        ModelAndView mav = new ModelAndView("editproduct");
        Product product = serviceProduct.getElemById(id);
        mav.addObject("product", product);
         
        return mav;
    }
    @RequestMapping(value = "/product/editsave/{product_id}", method = RequestMethod.POST)
    public String editSaveProduct(@ModelAttribute("product") Product product) {
        serviceProduct.update(product);  
        return "redirect:/product";
    }
    
    @RequestMapping("/product/delete/{product_id}")
    public String deleteProduct(@PathVariable(name = "product_id") Long id) {
        serviceProduct.delete(id);
        return "redirect:/product";       
    }
    **/
}