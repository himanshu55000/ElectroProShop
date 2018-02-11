package com.electroproshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ElectroProShopBacked.dao.CategoryDAO;
import com.ElectroProShopBacked.model.Product;

@Controller
public class ProductController {
	
	@Autowired
	CategoryDAO categoryDAO;
	
	@RequestMapping("/products/{cid}")
	public ModelAndView viewProductsByCat(@PathVariable int cid)
	{	ModelAndView m=new ModelAndView("viewProductByCategory");
		m.addObject("products",categoryDAO.getCategoryById(cid));
		return m;
	}

}
