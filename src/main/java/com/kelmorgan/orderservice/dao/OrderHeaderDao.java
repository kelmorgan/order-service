package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.OrderHeader;

public interface OrderHeaderDao {
    OrderHeader save (OrderHeader orderHeader);
}
