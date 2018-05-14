package com.umanav.productsandcategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.umanav.productsandcategories.models.Category;
import com.umanav.productsandcategories.models.Product;
import com.umanav.productsandcategories.repositories.ProductRepository;

@Service
public class ProductService {
	private ProductRepository productRepository;
	public ProductService (ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	public List<Product> all() {
		return productRepository.findAll();
	}
	public void add(Product product) {
		productRepository.save(product);
	}
	public Product getProduct(Long id) {
		return productRepository.findById(id).get();
	}
	public void updateProducts(Category category, Product product) {
		List <Category> cat = product.getCategories();
		cat.add(category);
		product.setCategories(cat);
		productRepository.save(product);
	}
	public List<Product> getOtherProducts(Category category) {
		List<Product> products = productRepository.findByCategoriesNotContains(category);
		return products;
	}
	public List<Product> product(Category category){
		return productRepository.findByCategories(category);
	}

}
