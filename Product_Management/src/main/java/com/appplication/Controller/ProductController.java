package com.appplication.Controller;
 
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appplication.Entity.Products;
import com.appplication.Service.ProductServiceImplementation;

@RestController
public class ProductController {
         
	ProductServiceImplementation productServiceImplementation;

	public ProductController(ProductServiceImplementation productServiceImplementation) {
		super();
		this.productServiceImplementation = productServiceImplementation;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createdProduct(@RequestBody Products product) {
		try {
			String saveProducts = productServiceImplementation.addProduct(product);
		return	ResponseEntity.ok(Map.of("message", "producted added", "Product", saveProducts));
		  
		} catch(RuntimeException e) {
	  return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
		}
		 
	}
	
	@GetMapping("/view/{id}")
	public Products viewProducts(@PathVariable Long id) {
		return productServiceImplementation.viewProduct(id);
	}
	
	 
	
	@PutMapping("/update")
	public String updated(@PathVariable Long id, @RequestBody Products retrieveProducts) {
		return  productServiceImplementation.updateProduct(id,retrieveProducts);
	    
	}
	
	@DeleteMapping("/delete/{id}")
	public String removeProduct(@PathVariable Long id) {
		productServiceImplementation.deleteProduct(id);
		return "DELETED successfully";
	}
	
	
	
}














