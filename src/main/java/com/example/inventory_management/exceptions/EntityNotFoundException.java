package com.example.inventory_management.exceptions;

import lombok.Getter;

public class EntityNotFoundException extends RuntimeException{

    @Getter
    private ErrorCodes errorCodes;

    public EntityNotFoundException(String msg){
        super(msg);
    }

    public EntityNotFoundException(String msg, Throwable cause){
        super(msg, cause);
    }

    public EntityNotFoundException(String msg, Throwable cause, ErrorCodes errorCodes){
        super(msg, cause);
        this.errorCodes = errorCodes;
    }

    public EntityNotFoundException(String msg, ErrorCodes errorCodes){
        super(msg);
        this.errorCodes = errorCodes;
    }
}
