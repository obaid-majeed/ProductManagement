package com.appplication.Service;

import java.util.List;
import java.util.Optional;

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
	
	 

	 
	public String addProduct(Products product) {
		productRepository.save(product);
		return "Product Added";
	}

	 
	public Products viewProduct(Long id) {
		  return productRepository.findById(id).orElse(null);
		  
	}

	 
	 
	public String updateProduct(Long id, Products retrieveProducts) {
	    Optional<Products> optionalProduct = productRepository.findById(id);
	    
	    if (optionalProduct.isPresent()) {
	        Products existingProduct = optionalProduct.get(); // 1. Unwrap the entity
	        
	        // 2. Update fields (do NOT alter existingProduct.setId)
	        existingProduct.setName(retrieveProducts.getName());
	        existingProduct.setPrice(retrieveProducts.getPrice());
	        existingProduct.setDescription(retrieveProducts.getDescription());
	        existingProduct.setPhotoUrl(retrieveProducts.getPhotoUrl());
	        
	        // 3. Save the unwrapped entity
	        productRepository.save(existingProduct);
	        return "Product updated successfully";
	    }
	    
	    return "Product not found with id: " + id;
	}
	

	 
	public boolean deleteProduct(Long id) {
		  if (productRepository.existsById(id)) {
			  productRepository.deleteById(id);
			  return true;
		  }
		return false;
	}

 
	@Override
	public List<Products> viewAllProducts() {
	return	productRepository.findAll();
	}
	
}

