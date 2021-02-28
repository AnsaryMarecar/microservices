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
import com.catastima.home.bean.ProductBean;
import com.catastima.home.bean.Seller;
import com.catastima.home.proxies.MicroServiceProxyProduct;
import com.catastima.home.proxies.ProxyCategory;
import com.catastima.home.proxies.ProxySeller;

@Controller
public class ProductController {

    @Autowired
    private MicroServiceProxyProduct ProductsProxy;
    
    @Autowired
    private ProxyCategory CategoryProxy;
    
    @Autowired
    private ProxySeller SellerProxy;

  //home page all product
    @RequestMapping("/")
    public String index(
    			Model model
    		,  	HttpSession session
    		) {
        List<Seller> sellers =  SellerProxy.listAll();
        model.addAttribute("sellers", sellers);
        return "choice";
    }
    
    //home page all product
    @RequestMapping("/home")
    public String home(
    			Model model
    		,  	HttpSession session
    		) {
        List<ProductBean> products =  ProductsProxy.listProducts();
        Seller seller =  SellerProxy.TakeOne((long)1);
        List<Category> categories =  CategoryProxy.listAll();
        model.addAttribute("products", products);
        model.addAttribute("seller", seller);
        model.addAttribute("categories", categories);
        return "index";
    }
    
    
  //home page all product
    @RequestMapping("/home/{seller_id}")
    public String homeBySeller(
    			Model model
    		, 	@PathVariable(name = "seller_id") Long seller_id
    		,  	HttpSession session
    		) {
        List<ProductBean> products =  ProductsProxy.TakeProductShop(seller_id);
        Seller seller =  SellerProxy.TakeOne(seller_id);
        List<Category> categories =  CategoryProxy.listAll();
        model.addAttribute("products", products);
        model.addAttribute("seller", seller);
        model.addAttribute("categories", categories);
        return "index";
    }
    
    //home page all product
    @RequestMapping("/{seller_id}/cat/{category_id}")
    public String homeBySellerCategory(
    			Model model
    		, 	@PathVariable(name = "seller_id") Long seller_id
    		, 	@PathVariable(name = "category_id") Long category_id
    		,  	HttpSession session
    		) {
    	List<Long> categoriesFilter = CategoryProxy.listAll(category_id);
        List<ProductBean> products =  ProductsProxy.TakeProductShopCategories(seller_id, categoriesFilter);
        Seller seller =  SellerProxy.TakeOne(seller_id);
        Category category = CategoryProxy.TakeOne(category_id);
        List<Category> categories =  CategoryProxy.listAll();
        model.addAttribute("products", products);
        model.addAttribute("seller", seller);
        model.addAttribute("categories", categories);
        model.addAttribute("category", category);
        return "index";
    }
    
    @RequestMapping("/product")
    public String viewProductPage(
    			Model model
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
	    	List<ProductBean> listProducts = ProductsProxy.listProducts();
	        model.addAttribute("listProducts", listProducts);
	        model.addAttribute("name", username);
	        return "product";
    	}
    	return "redirect:/home";
    }
  
    //page product (with data)
    @SuppressWarnings("null")
	@RequestMapping("/product/{id}")
    public String viewProduct(Model model
    		, @PathVariable(name = "product_id") Long product_id
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
	    	ProductBean product = ProductsProxy.TakeProduct(product_id);
	    	List<ProductBean> listProducts = null;
	    	listProducts.add(product);
	    	model.addAttribute("listProducts", listProducts);
	    	model.addAttribute("name", username);
	        return "product";
    	}
    	return "redirect:/home";
    }
    
    //page add product (without data)
    @RequestMapping("/product/newproduct")
    public String viewNewProductPage(
    			Model model
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		ProductBean product = new ProductBean();
    	    model.addAttribute("product", product);
    	    model.addAttribute("name", username);
    	    return "newproduct";
    	}
    	return "redirect:/home";
    }
    
    //page edit product (with data, without saving) //
    @RequestMapping("/product/edit/{product_id}")
    public String viewEditProductPage(
    			Model model
    		,	@PathVariable(name = "product_id") Long product_id
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		ProductBean product = ProductsProxy.TakeProduct(product_id);
    		model.addAttribute("product", product);
    		model.addAttribute("name", username);
    		return "editproduct";
    	}
    	return "redirect:/home";
    }
    
    @RequestMapping(value = "/product/save", method = RequestMethod.POST)
    public String saveProduct(
    			@ModelAttribute("product") ProductBean product
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		ProductsProxy.add(product);
    		return "redirect:/product";
    	}
    	return "redirect:/home";
    }
    
    @RequestMapping(value = "/product/editsave", method = RequestMethod.POST)
    public String editSaveProduct(
    			@ModelAttribute("product") ProductBean product
    		,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		ProductsProxy.update(product);
    		return "redirect:/product";
    	}
    	return "redirect:/home";
    }

    @RequestMapping("/product/delete/{product_id}")
    public String deleteProduct(
    			@PathVariable(name = "product_id") Long id
    			,  	HttpSession session
    		) {
    	String username = (String)session.getAttribute("username");
    	if(username != null) {
    		ProductsProxy.delete(id);
    		return "redirect:/product";
    	}
    	return "redirect:/home";       
    }
}