package com.appplication.Service;

import java.util.List;

import com.appplication.Entity.Products;

public interface ProductService {
        
	String addProduct(Products product);
	Products viewProduct(Long id);
	String updateProduct(Products id);
	String deleteProduct(Long id);
	List<Products> viewAllProducts();
}
