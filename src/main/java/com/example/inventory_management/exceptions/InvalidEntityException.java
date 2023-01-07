package com.example.inventory_management.exceptions;

import lombok.Getter;

import java.util.List;

public class InvalidEntityException extends RuntimeException{
    @Getter
    private ErrorCodes errorCodes;
    @Getter
    private List<String> errors;

    public InvalidEntityException(String msg){
        super(msg);
    }

    public InvalidEntityException(String msg, Throwable cause){
        super(msg, cause);
    }

    public InvalidEntityException(String msg, Throwable cause, ErrorCodes errorCodes){
        super(msg, cause);
        this.errorCodes = errorCodes;
    }

    public InvalidEntityException(String msg, ErrorCodes errorCodes){
        super(msg);
        this.errorCodes = errorCodes;
    }

    public InvalidEntityException(String msg, ErrorCodes errorCodes, List<String> errors){
        super(msg);
        this.errorCodes = errorCodes;
        this.errors.addAll(errors);
    }
}
