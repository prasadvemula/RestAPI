package com.myretail.service.item;

import com.myretail.rest.product.response.ProductResponse;

public interface ItemService {
    public ProductResponse getProductDetails(String id);
}
