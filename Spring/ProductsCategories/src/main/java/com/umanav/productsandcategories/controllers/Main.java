package com.umanav.productsandcategories.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.umanav.productsandcategories.models.Category;
import com.umanav.productsandcategories.models.Product;
import com.umanav.productsandcategories.services.CategoryService;
import com.umanav.productsandcategories.services.ProductService;

@Controller
public class Main {
	//service
	private final CategoryService categoryService;
	private final ProductService productService;
	//constructor
	public Main(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}
	@RequestMapping("/")
	public String main() {
		return "Main.jsp";
	}
	//PRODUCTS
	@RequestMapping("/products")
	public String viewProducts(Model model) {
		List<Product> listProducts =  productService.all();
		model.addAttribute("listProducts",listProducts);
		return "viewAllProducts.jsp";
	}
	@RequestMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product) {
		return "addProduct.jsp";
	}
	@PostMapping("/products/new")
	public String addProduct(@ModelAttribute("product") Product product, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct.jsp";
	    }else{
	    	productService.add(product);
	    	return "redirect:/";
	    }
	}
	@RequestMapping("/products/{id}")
	public String viewProducts(@PathVariable("id") Long id, Model model) {
		Product product = productService.getProduct(id);
		List <Category> NotCategories = categoryService.getOtherCategories(product);
		List <Category> categories = categoryService.category(product);
		model.addAttribute("product", product);
		model.addAttribute("categories", categories);
		model.addAttribute("NotCategories", NotCategories);
		return "viewProduct.jsp";
	}
	@PostMapping("/products/{id}/add")
	public String addRelationProd(@PathVariable("id") Long id, @RequestParam("category") Long category_id) {
		Product product = productService.getProduct(id);
		Category category = categoryService.findById(category_id);
		productService.updateProducts(category, product);
    	return "redirect:/products";
	}
	
	//CATEGORIES
	@RequestMapping("/categories")
	public String viewCategories(Model model) {
		List<Category> listCategories =  categoryService.all();
		model.addAttribute("listCategories",listCategories);
		return "viewAllCategory.jsp";
	}
	@RequestMapping("/categories/new")
	public String newCategory(@ModelAttribute("category") Category category) {
		return "addCategory.jsp";
	}
	@PostMapping("/categories/new")
	public String addCategory(@ModelAttribute("category") Category category, BindingResult result) {
		if (result.hasErrors()) {
			return "addProduct.jsp";
	    }else{
	    	categoryService.add(category);
	    	return "redirect:/";
	    }
	}
	@RequestMapping("/categories/{id}")
	public String viewCategories(@PathVariable("id") Long id, Model model) {
		Category  category = categoryService.getCategory(id);
		List <Product> Notproducts = productService.getOtherProducts(category);
		List <Product> products = productService.product(category);
		model.addAttribute("category", category);
		model.addAttribute("products", products);
		model.addAttribute("Notproducts", Notproducts);
		return "viewCategory.jsp";
	}
	@PostMapping("/categories/{id}/add")
	public String addRelationCat(@PathVariable("id") Long id, @RequestParam("product") Long product_id) {
		Product product = productService.getProduct(product_id);
		Category category = categoryService.findById(id);
		productService.updateProducts(category, product);
    	return "redirect:/categories";
	}
}
