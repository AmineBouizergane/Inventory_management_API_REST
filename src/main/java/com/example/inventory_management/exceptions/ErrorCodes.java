package com.example.inventory_management.exceptions;

public enum ErrorCodes {
    ITEM_NOT_FOUND(1000),
    ITEM_NOT_VALID(1001),
    CATEGORY_NOT_FOUND(2000),
    CATEGORY_NOT_VALID(2001),
    CLIENT_NOT_FOUND(3000),
    CLIENT_NOT_VALID(3001),
    ORDER_CLIENT_NOT_FOUND(4000),
    ORDER_CLIENT_NOT_VALID(4001),
    COMPANY_NOT_FOUND(5000),
    COMPANY_NOT_VALID(5001),
    ORDER_SUPPLIER_NOT_FOUND(6000),
    ORDER_SUPPLIER_NOT_VALID(6001),
    SUPPLIER_NOT_FOUND(7000),
    SUPPLIER_NOT_VALID(7001),
    USER_NOT_FOUND(8000),
    USER_NOT_VALID(8000);

    private int code;
    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
