package com.appplication.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appplication.Entity.Products;
import com.appplication.Repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService
                 {
          
	ProductRepository productRepository;

	public ProductServiceImplementation(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	
	 

	@Override
	public String addProduct(Products product) {
		productRepository.save(product);
		return "Product Added";
	}

	@Override
	public Products viewProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateProduct(Products id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Products> viewAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}
}

