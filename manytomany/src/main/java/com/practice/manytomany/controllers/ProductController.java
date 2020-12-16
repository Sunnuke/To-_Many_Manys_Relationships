package com.practice.manytomany.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.practice.manytomany.models.Category;
import com.practice.manytomany.models.Product;
import com.practice.manytomany.services.CategoryService;
import com.practice.manytomany.services.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	// New Product
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product, Model model) {
		return "/newProduct.jsp";
	}
	
	// Create Product
	@RequestMapping(value = "/Product", method = RequestMethod.POST)
	public String creatProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/products/new";
		} else {
			Long id = productService.createProduct(product).getId();
			return "redirect:/products/" + id;
		}	
	}
	
	// Selected Product
	@RequestMapping("/products/{id}")
	public String product(@PathVariable("id") Long id, Model model, @ModelAttribute("category") Category category) {
		Product product = productService.findProduct(id);
		List<Category> categories = product.getCategories();
		List<Category> menu = categoryService.allCategory();
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		model.addAttribute("menu", menu);
		return "product.jsp";
	}

	// Add Category to Product
	@RequestMapping(value = "/AddCategory/{id}", method = RequestMethod.POST)
	public String addCategory(@PathVariable("id") Long id, @ModelAttribute("category") Long category, Model model) {
		Category categoryOg = categoryService.findCategory(category);
		productService.addCategory(categoryOg, id);
		return "redirect:/products/" + id;
	}
}
