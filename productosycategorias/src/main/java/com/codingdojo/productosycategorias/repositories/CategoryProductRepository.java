package com.codingdojo.productosycategorias.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.productosycategorias.models.CategoryProduct;

@Repository
public interface CategoryProductRepository extends CrudRepository <CategoryProduct, Long>{
	List<CategoryProduct> findAll();
}
