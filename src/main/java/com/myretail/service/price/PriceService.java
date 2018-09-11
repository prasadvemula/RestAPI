package com.myretail.service.price;

import com.myretail.data.respository.entity.Price;
import com.myretail.rest.product.request.PriceRequest;


public interface PriceService {
    Price fetchPrice(String id);
    Price createPrice(PriceRequest priceRequest);
}
