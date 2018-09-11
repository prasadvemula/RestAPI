package com.myretail.rest.product.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ItemResponse {
    private Product product;

    @Data
    @Setter
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Product {
        private Item item;
    }

    @Data

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Item{
        private String tcin;
        @JsonProperty("product_description")
        private ProductDescription productDescription;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ProductDescription {
        private String title;
    }

}




