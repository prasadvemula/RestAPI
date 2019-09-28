package com.myretail.rest.product.response;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ProductResponse {
    @JsonProperty("part_number")
    private String partNumber;

    private String title;

    @JsonProperty("current_price")
    private Price price;

    @Data
    public static class Price {
        private String value;
        private String currency;
    }
}
