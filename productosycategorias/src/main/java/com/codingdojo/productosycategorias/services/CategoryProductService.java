package com.codingdojo.productosycategorias.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.CategoryProduct;
import com.codingdojo.productosycategorias.repositories.CategoryProductRepository;

@Service
public class CategoryProductService {
	@Autowired
	CategoryProductRepository categoryProductRepository;
	
	public void addCategoryProduct(CategoryProduct categoryProduct) {
		categoryProductRepository.save(categoryProduct);
	}
	
	public void addProdudctCategory(CategoryProduct categoryProduct) {
		categoryProductRepository.save(categoryProduct);
	}
	public List<CategoryProduct> findAllcatToProd() {
		return categoryProductRepository.findAll();
	}
	
}
