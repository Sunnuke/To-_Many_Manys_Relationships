package com.practice.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.practice.manytomany.models.Product;
import com.practice.manytomany.repositories.ProductRepository;

public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
//	RETRIEVE
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	
	public Product findProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if (optionalProduct.isPresent()) {
			return optionalProduct.get();
		}
		else {
			return null;
		}

	}
	
//	CREATE
	public Product createProduct(Product product) {
		return productRepository.save(product);
		
	}

}
