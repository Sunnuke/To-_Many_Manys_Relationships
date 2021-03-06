package com.practice.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.manytomany.models.Category;
import com.practice.manytomany.models.Product;
import com.practice.manytomany.repositories.ProductRepository;

@Service
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
	
	public Product addCategory(Category category, Long id) {
		Product product = findProduct(id);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		return productRepository.save(product);
	}
	
}
