package com.appplication.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appplication.Entity.Products;

public interface ProductRepository extends JpaRepository<Products,Long> {
             
}
