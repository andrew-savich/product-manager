package com.andrewsavich.productmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrewsavich.productmanager.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
		
}
