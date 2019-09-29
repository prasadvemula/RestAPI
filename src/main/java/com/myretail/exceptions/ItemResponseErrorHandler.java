package com.myretail.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.DefaultResponseErrorHandler;

import java.io.IOException;


@Component
public class ItemResponseErrorHandler extends DefaultResponseErrorHandler {
    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        if (response.getStatusCode().equals(HttpStatus.BAD_REQUEST)) {
            throw new ProductException("ERR_FAILED_INVALID_REQUEST");
        } else if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
            throw new ProductException("ERR_FAILED_ITEM_NOT_FOUND");
        } else if (response.getStatusCode().equals(HttpStatus.REQUEST_TIMEOUT)) {
            throw new ProductException("ERR_FAILED_REQUEST_TIMEOUT");
        } else if (response.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
            throw new ProductException("ERR_FAILED_FORBIDDEN");
        } else if (response.getStatusCode().equals(HttpStatus.UNAUTHORIZED)) {
            throw new ProductException("ERR_FAILED_UNAUTHORIZED");
        } else if (response.getStatusCode().is5xxServerError()) {
            throw new ProductException("ERR_ITEM_INTEGRATION");
        }
        super.handleError(response);
    }
}
