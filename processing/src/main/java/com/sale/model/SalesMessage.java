package com.sale.model;

import com.sale.constant.MessageType;

import java.math.BigDecimal;

public class SalesMessage {

    private Sale sale;
    private MessageType messageType;
    private Adjustment adjustment;
    private boolean isAdjustment;

    public SalesMessage(){
        sale = new Sale();
        adjustment = new Adjustment();
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Adjustment getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Adjustment adjustment) {
        this.adjustment = adjustment;
    }

    public boolean isAdjustment() {
        return isAdjustment;
    }

    public void setAdjustment(boolean adjustment) {
        isAdjustment = adjustment;
    }

    @Override
    public String toString() {
        return "SalesMessage{" +
                "sale=" + sale +
                ", messageType=" + messageType +
                ", adjustment=" + adjustment +
                ", isAdjustment=" + isAdjustment +
                '}';
    }
}
