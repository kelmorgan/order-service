package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.OrderHeader;
import com.kelmorgan.orderservice.repositories.OrderHeaderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class OrderHeaderDaoImpl implements OrderHeaderDao {

    private final OrderHeaderRepository repository;

    @Override
    public OrderHeader save(OrderHeader orderHeader) {
        return repository.save(orderHeader);
    }
}
