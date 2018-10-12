package com.niit.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.dao.ProductDao;
import com.niit.model.Product;


@Controller
public class ProductController {
	@Autowired
	
	private ProductDao productDao;
	public ProductController(){
		
		System.out.println("ProductController  bean is created ");
	}
	@RequestMapping(value="/all/getallproducts")
	public String getAllProducts(Model model){
		List<Product> products=productDao.getAllProducts();
		
		
		model.addAttribute("productsList",products);
		return "listofproducts";
		
	}

	}
