package com.metro.homework.ecommerce.service.exception;

import java.util.function.Supplier;

public class ExceptionUtils {

    public static Supplier<ObjectNotFoundException> getObjectNotFoundExceptionSupplier(Long entityId, String s) {
        return () -> new ObjectNotFoundException(s + entityId);
    }

}
