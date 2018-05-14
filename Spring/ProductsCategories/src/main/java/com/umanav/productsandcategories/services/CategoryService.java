package com.umanav.productsandcategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.umanav.productsandcategories.models.Category;
import com.umanav.productsandcategories.models.Product;
import com.umanav.productsandcategories.repositories.CategoryRepository;

@Service
public class CategoryService {
	private CategoryRepository categoryRepository;
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	public List<Category> all() {
		return categoryRepository.findAll();
	}
	public void add(Category category) {
		categoryRepository.save(category);
	}
	public Category getCategory(Long id) {
		return categoryRepository.findById(id).get();
	}
	public List<Category> getOtherCategories(Product product) {
		List<Category> categories = categoryRepository.findByProductsNotContains(product);
		return categories;
	}
	public List<Category> category(Product product){
		return categoryRepository.findByProducts(product);
	}
	public Category findById(Long id) {
		return categoryRepository.findById(id).get();
	}
	public void updateProducts(Category category, Product product) {
		List <Product> prod = category.getProducts();
		prod.add(product);
		category.setProducts(prod);
		categoryRepository.save(category);
	}
}