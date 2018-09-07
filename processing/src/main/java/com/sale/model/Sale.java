package com.sale.model;

import java.math.BigDecimal;
import java.util.List;

public class Sale {

    private String productType;
    private Integer quantity;
    private BigDecimal price;

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Sale{" +
                "productType='" + productType + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
