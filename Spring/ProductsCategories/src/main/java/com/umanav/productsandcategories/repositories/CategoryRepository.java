package com.umanav.productsandcategories.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.umanav.productsandcategories.models.Category;
import com.umanav.productsandcategories.models.Product;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	List<Category> findAll();
	List<Category> findByProductsNotContains(Product product);
	List<Category> findByProducts(Product product);
	List<Category> findByProductsIsNull();
	void save(Product product);
}
