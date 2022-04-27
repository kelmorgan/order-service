package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.OrderHeader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
@ComponentScan(basePackages = {"com.kelmorgan.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class OrderHeaderDaoImplTest {

    @Autowired
    OrderHeaderDao orderHeaderDao;


    @Test
    void save() {
        OrderHeader orderHeader = new OrderHeader();
        orderHeader.setCustomerName("Kufre Godwin");

        OrderHeader savedOrderHeader = orderHeaderDao.save(orderHeader);

        System.out.println(savedOrderHeader);
        System.out.println("Created Date: "+ savedOrderHeader.getCreatedDate());
        System.out.println("Last Modified Date: "+  savedOrderHeader.getLastModifiedDate());
        assertThat(savedOrderHeader).isNotNull();
        assertThat(savedOrderHeader.getId()).isNotNull();
        assertThat(savedOrderHeader.getCreatedDate()).isNotNull();
        assertThat(savedOrderHeader.getLastModifiedDate()).isNotNull();
    }
}