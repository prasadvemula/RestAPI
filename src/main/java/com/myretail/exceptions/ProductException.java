package com.myretail.exceptions;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
public class ProductException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private int code;
    private String errorKey;
    private String message;

    public ProductException(String errorKey) {
        super(errorKey);
        this.errorKey = errorKey;
    }

    public ProductException(String errorKey, Throwable e) {
        super(errorKey, e);
        this.errorKey = errorKey;
        this.message = message;
    }

}
