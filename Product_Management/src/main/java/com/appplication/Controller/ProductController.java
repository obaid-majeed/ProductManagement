package com.appplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appplication.Entity.Products;
import com.appplication.Service.ProductServiceImplementation;

@Controller
@RequestMapping("/product")
public class ProductController {
         
	ProductServiceImplementation productServiceImplementation;

	public ProductController(ProductServiceImplementation productServiceImplementation) {
		super();
		this.productServiceImplementation = productServiceImplementation;
	}
	
	public String createdProduct(@RequestBody Products product) {
		return productServiceImplementation.addProduct(product);
		 
	}
}
