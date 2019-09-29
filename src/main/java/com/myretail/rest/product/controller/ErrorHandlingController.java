package com.myretail.rest.product.controller;

import com.myretail.exceptions.ProductException;
import com.myretail.exceptions.ProductExceptionResponse;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.lang.annotation.Annotation;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice
public class ErrorHandlingController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ProductExceptionResponse> generalException(Exception exception)
            throws  Exception {
        ProductExceptionResponse response = new ProductExceptionResponse();
        HttpStatus status = getHttpStatus(exception);
        response.setCode(status.value());
        response.setDescription(exception.getMessage());
        return new ResponseEntity<ProductExceptionResponse>(response, status);
    }

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ProductExceptionResponse> generalException(ProductException e)
            throws  Exception {
        ProductExceptionResponse response = new ProductExceptionResponse();
        HttpStatus status = getHttpStatus(e);
        response.setCode(status.value());
        response.setDescription(e.getMessage());
        return new ResponseEntity<ProductExceptionResponse>(response, status);
    }

    protected HttpStatus getHttpStatus(Exception e) {
        HttpStatus httpStatus;
        Annotation statusAnnotation
                = AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class);
        if (statusAnnotation != null) {
            httpStatus = (HttpStatus) AnnotationUtils.getValue(statusAnnotation);
        } else {
            httpStatus = INTERNAL_SERVER_ERROR;
        }
        return httpStatus;
    }
}
