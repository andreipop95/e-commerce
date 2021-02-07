package com.metro.homework.ecommerce.service.exception;


public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(String message) {
        super(message);
    }
}
