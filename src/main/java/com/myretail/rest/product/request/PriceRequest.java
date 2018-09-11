package com.myretail.rest.product.request;


import lombok.Data;

@Data
public class PriceRequest {
    private String id;
    private String price;
    private String currency;
}
