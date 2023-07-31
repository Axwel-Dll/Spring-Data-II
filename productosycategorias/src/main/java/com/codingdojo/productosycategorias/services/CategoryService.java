package com.codingdojo.productosycategorias.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.productosycategorias.models.Category;
import com.codingdojo.productosycategorias.models.Product;
import com.codingdojo.productosycategorias.repositories.CategoryRepository;

@Service
public class CategoryService {
	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	public void createCategory(Category category) {
		categoryRepository.save(category);
	}

	public List<Category> findAllCategories() {
		return categoryRepository.findAll();
	}

	public Category findCategory(Long id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (category.isPresent()) {
			return category.get();
		} else {
			return null;
		}
	}
    public List<Category> categoriaDisponibles(Product product) {
        return categoryRepository.findByProductsNotContains(product);  
    }
}
