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

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	// New Category
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category, Model model) {
		return "/newCategory.jsp";
	}
	
	// Create Category
	@RequestMapping(value = "/Category", method = RequestMethod.POST)
	public String creatCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "redirect:/categories/new";
		} else {
			Long id = categoryService.createCategory(category).getId();
			return "redirect:/categories/" + id;
		}	
	}
	
	// Selected Category
	@RequestMapping("/categorys/{id}")
	public String category(@PathVariable("id") Long id, Model model) {
		Category category = categoryService.findCategory(id);
		List<Product> products = category.getProducts();
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		return "category.jsp";
	}

}
