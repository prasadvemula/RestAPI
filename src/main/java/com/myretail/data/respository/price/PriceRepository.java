package com.myretail.data.respository.price;

import com.myretail.data.respository.entity.Price;

public interface PriceRepository {
    Price fetchPrice(String id);
    Price createPrice(Price price);
}
