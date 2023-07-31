package com.codingdojo.productosycategorias.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.services.CategoryProductService;
import com.codingdojo.productosycategorias.services.CategoryService;
import com.codingdojo.productosycategorias.services.ProductService;

import jakarta.validation.Valid;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	CategoryProductService categoryProductService;
	
	@RequestMapping("/")
	public String index() {
		return "/views/index.jsp";
	}
	
	// product
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "views/newproduct.jsp";
	}

	@PostMapping("/products/new")
	public String createProduct(@Valid @ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "views/newproduct.jsp";
		} else {
			productService.createProduct(product);
			return "redirect:/products/new";
		}
	}

	// category
	@GetMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "views/newcategory.jsp";
	}

	@PostMapping("/categories/new")
	public String createCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "views/newcategory.jsp";
		} else {
			categoryService.createCategory(category);
			return "redirect:/categories/new";
		}
	}
	
	@GetMapping("/products/{id}")
	public String showProduct(@PathVariable("id") Long id,@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, Model model) {
		Product product = productService.findProduct(id);
		model.addAttribute("product", product);
		model.addAttribute("categories", categoryService.categoriaDisponibles(product));
		return "views/productpage.jsp";
	}

	@PostMapping("/products/{idProduct}")
	public String addCategoryProduct(@ModelAttribute("categoryProduct") CategoryProduct categoryProduct, @PathVariable("idProduct") Long id, BindingResult result) {
		if (result.hasErrors()) {
			return "views/productpage.jsp";
		} else {
			categoryProductService.addCategoryProduct(categoryProduct);
			return "redirect:/products/" + categoryProduct.getProduct().getId();
		}
	}
	@GetMapping("/categories/{id}")
	public String showCategory(@PathVariable("id") Long id,@ModelAttribute("productCategory") CategoryProduct categoryProduct, Model model) {
		Category category = categoryService.findCategory(id);
		model.addAttribute("category", category);
		model.addAttribute("products", productService.productosDisponibles(category));
		return "views/categorypage.jsp";
	}
	@PostMapping("/categories/{idCategory}")
	public String addProductCategory(@ModelAttribute("productCategory") CategoryProduct categoryProduct, @PathVariable("idCategory") Long id, BindingResult result) {
		if (result.hasErrors()) {
			return "views/categorypage.jsp";
		} else {
			categoryProductService.addProdudctCategory(categoryProduct);
			return "redirect:/categories/" + id;
		}
	}
	
}
