package com.kelmorgan.orderservice.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class OrderLine extends BaseEntity {

    private Integer quantityOrdered;
    @ManyToOne
    private OrderHeader orderHeader;

    @ManyToOne
    private Product product;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        OrderLine orderLine = (OrderLine) o;

        if (quantityOrdered != null ? !quantityOrdered.equals(orderLine.quantityOrdered) : orderLine.quantityOrdered != null)
            return false;
        if (orderHeader != null ? !orderHeader.equals(orderLine.orderHeader) : orderLine.orderHeader != null)
            return false;
        return product != null ? product.equals(orderLine.product) : orderLine.product == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (quantityOrdered != null ? quantityOrdered.hashCode() : 0);
        result = 31 * result + (product != null ? product.hashCode() : 0);
        return result;
    }
}
