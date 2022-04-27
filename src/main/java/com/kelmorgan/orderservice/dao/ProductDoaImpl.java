package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.Product;
import com.kelmorgan.orderservice.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductDoaImpl implements ProductDoa {
    private final ProductRepository repository;

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public Product getProductById(Long id) {
        return repository.getById(id);
    }
}
