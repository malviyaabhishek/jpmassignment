package com.sale.constant;

public enum AdjustmentType{
    ADD("ADD"), SUBTRACT("SUBTRACT"), MULTIPLY("MULTIPLY");

    private String adustmentDesc;

    private AdjustmentType(String adustmentDesc){
        this.adustmentDesc = adustmentDesc;
    }
}
