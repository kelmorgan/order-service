package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.OrderHeader;
import com.kelmorgan.orderservice.domain.OrderLine;
import com.kelmorgan.orderservice.domain.Product;
import com.kelmorgan.orderservice.domain.ProductStatus;
import com.kelmorgan.orderservice.repositories.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"com.kelmorgan.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderDaoImplTest {

    @Autowired
    OrderHeaderDao orderHeaderDao;

    @Autowired
    ProductRepository productRepository;

    Product product;

    @BeforeEach
    void setUp() {
        Product newProduct = new Product();
        newProduct.setProductStatus(ProductStatus.NEW);
        newProduct.setDescription("test product");
        product = productRepository.saveAndFlush(newProduct);
    }

    @Test
    void save() {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Kufre Godwin");


        OrderLine orderLine = new OrderLine();
        orderLine.setQuantityOrdered(5);
        orderLine.setProduct(product);
        orderHeader.addOrderLine(orderLine);


        OrderHeader savedOrderHeader = orderHeaderDao.save(orderHeader);
        assertThat(savedOrderHeader).isNotNull();
        assertThat(savedOrderHeader.getId()).isNotNull();
        assertThat(savedOrderHeader.getCreatedDate()).isNotNull();
        assertThat(savedOrderHeader.getLastModifiedDate()).isNotNull();
        assertThat(savedOrderHeader.getOrderLines()).isNotNull();
    }
}