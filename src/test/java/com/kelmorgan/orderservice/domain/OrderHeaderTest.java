package com.kelmorgan.orderservice.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OrderHeaderTest {

    @Test
    void testEqualsBeforeImplementing() {
        OrderHeader oh1 = new OrderHeader();

        oh1.setId(1L);

        OrderHeader oh2 = new OrderHeader();

        oh2.setId(1L);

        assertThat(oh1).isEqualTo(oh2);
    }
}