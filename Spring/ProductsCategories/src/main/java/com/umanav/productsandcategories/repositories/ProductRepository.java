package com.umanav.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umanav.productsandcategories.models.Category;
import com.umanav.productsandcategories.models.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	List<Product> findAll();
	List<Product> findByCategoriesNotContains(Category category);
	List<Product> findByCategories(Category category);
	List<Product> findByCategoriesIsNull();
	void save(Category category);
	
}
