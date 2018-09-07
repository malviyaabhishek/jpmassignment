package com.sale.model;

import com.sale.constant.AdjustmentType;

import java.math.BigDecimal;

public class Adjustment {

    private AdjustmentType adjustmentType;
    private BigDecimal price;
    private Integer quantity;

    public AdjustmentType getAdjustmentType() {
        return adjustmentType;
    }

    public void setAdjustmentType(AdjustmentType adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Adjustment{" +
                "adjustmentType=" + adjustmentType +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
