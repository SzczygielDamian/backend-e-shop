package com.damian.spring_boot_eshop.dao;

import com.damian.spring_boot_eshop.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByEmail(String email);
}
