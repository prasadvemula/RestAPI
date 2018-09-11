package com.myretail.facade;

import com.myretail.rest.product.response.ItemResponse;

public interface ItemFacade {
    public ItemResponse getItem(String id);
}
