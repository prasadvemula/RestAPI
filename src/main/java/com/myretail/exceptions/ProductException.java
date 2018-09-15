package com.myretail.exceptions;


import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.IOException;


@Component
@Data
public class ProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String errorKey;
    private String message;

    public ProductException() {

    }
    public ProductException(String errorKey) {
        this.errorKey = errorKey;
    }

    public ProductException(String errorKey, String message) {
        this.errorKey = errorKey;
        this.message = message;
    }

}
