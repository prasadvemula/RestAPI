package com.myretail.rest.product.response;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
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
