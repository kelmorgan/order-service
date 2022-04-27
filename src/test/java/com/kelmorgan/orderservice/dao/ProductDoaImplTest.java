package com.kelmorgan.orderservice.dao;

import com.kelmorgan.orderservice.domain.Product;
import com.kelmorgan.orderservice.domain.ProductStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ComponentScan(basePackages = {"com.kelmorgan.orderservice.dao"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProductDoaImplTest {

    @Autowired
    ProductDoa productDoa;

    @Test
    void save() {
        Product product = new Product();
        product.setProductStatus(ProductStatus.NEW);
        product.setDescription("New Samsung A13");

        Product saved = productDoa.save(product);

        System.out.println(saved);
        System.out.println("Created Date: "+ saved.getCreatedDate());
        System.out.println("Modified Date: "+ saved.getLastModifiedDate());

        assertThat(saved).isNotNull();
        assertThat(saved.getId()).isNotNull();
    }

    @Test
    void getProductById() {

        Product product = new Product();
        product.setProductStatus(ProductStatus.IN_STOCK);
        product.setDescription("New Samsung A52");

        Product saved = productDoa.save(product);

        System.out.println("Saved Product id: "+ saved.getId());
        Product fetched = productDoa.getProductById(saved.getId());

        System.out.println("Fetched Product: "+ fetched);
        System.out.println("Fetched CreatedDate: "+ fetched.getCreatedDate());
        System.out.println("Fetched Id: "+ fetched.getId());

        assertThat(fetched).isNotNull();
        assertThat(fetched.getId()).isNotNull();
    }
}