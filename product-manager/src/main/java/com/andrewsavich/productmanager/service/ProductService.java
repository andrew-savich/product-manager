package com.andrewsavich.productmanager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrewsavich.productmanager.model.Product;
import com.andrewsavich.productmanager.repository.ProductRepository;

@Service
public class ProductService {
	@Autowired
	private ProductRepository repository;

	public List<Product> getAllProducts(){
		return repository.findAll();
	}
	
	public void savevProduct(Product product) {
		repository.save(product);
	}
	
	public Product getProduct(Long id) {
		return repository.findById(id).get();
	}
	
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}
}