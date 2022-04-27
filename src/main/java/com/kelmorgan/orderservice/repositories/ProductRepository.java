package com.kelmorgan.orderservice.repositories;

import com.kelmorgan.orderservice.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByDescription(String description);
}