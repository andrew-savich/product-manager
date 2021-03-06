package com.andrewsavich.productmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping("/new")
	public String showNewProductForm(Model model) {
		Product product = new Product();
		model.addAttribute("product", product);

		return "new_product";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveNewProduct(@ModelAttribute("product") Product product) {
		service.savevProduct(product);
		
		return "redirect:/";
	}
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditProductForm(@PathVariable(name = "id") Long id) {
		ModelAndView modelAndView = new ModelAndView("edit_product");
		
		Product product = service.getProduct(id);
		modelAndView.addObject("product", product);
		
		return modelAndView;
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteProduct(@PathVariable(name = "id") Long id) {
		service.deleteProduct(id);
		
		return "redirect:/";
	}
}
