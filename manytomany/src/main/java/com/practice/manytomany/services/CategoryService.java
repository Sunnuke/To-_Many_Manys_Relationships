package com.practice.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.manytomany.models.Category;
import com.practice.manytomany.models.Product;
import com.practice.manytomany.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
//	RETRIEVE
	public List<Category> allCategory(){
		return categoryRepository.findAll();
	}
	
	
	public Category findCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if (optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		else {
			return null;
		}

	}
	
//	CREATE
	public Category createCategory(Category category) {
		return categoryRepository.save(category);
		
	}
	
	public Category addProduct(Product product, Long id) {
		Category category = findCategory(id);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		return categoryRepository.save(category);
	}

}
