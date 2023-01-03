package com.example.inventory_management.exceptions;

public enum ErrorCodes {
    ARTICLE_NOT_FOUND(1000),
    CATEGORY_NOT_FOUND(2000),
    CLIENT_NOT_FOUND(3000),
    ORDER_CLIENT_NOT_FOUND(4000);

    private int code;
    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
