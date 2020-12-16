package com.practice.manytomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.manytomany.models.Category;
import com.practice.manytomany.models.Product;
import com.practice.manytomany.services.ProductService;

public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	// New Product
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "/newProduct.jsp";
	}
	
	// Create Product
	@RequestMapping(value = "/Product", method = RequestMethod.POST)
	public String creatCategory(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			Long id = productService.createProduct(product).getId();
			return "redirect:/products/" + id;
		}	
	}
	
	// Selected Product
	@RequestMapping("/products/{id}")
	public String product(@PathVariable("id") Long id, Model model) {
		Product product = productService.findProduct(id);
		List<Category> categories = product.getCategories();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		return "category.jsp";
	}
}
