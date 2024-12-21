package com.damian.spring_boot_eshop.dao;


import com.damian.spring_boot_eshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

//@CrossOrigin("http://localhost:4200")
public interface ProductRepository extends JpaRepository<Product, Long> {
}
