package com.andrewsavich.productmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andrewsavich.productmanager.model.Product;
import com.andrewsavich.productmanager.service.ProductService;

@Controller
public class AppController {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping("/")
	public String viewHomePage(Model model) {
		List<Product> products = service.getAllProducts();
		model.addAttribute("products", products);
		
		return "index";
	}
}
