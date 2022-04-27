package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.Product;

public interface ProductDoa {

    Product save (Product product);

    Product getProductById(Long id);
}
