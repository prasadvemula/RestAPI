package com.myretail.service.price.impl;

import com.myretail.data.respository.price.PriceRepository;
import com.myretail.data.respository.entity.Price;
import com.myretail.rest.product.request.PriceRequest;
import com.myretail.service.price.PriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

@Service
public class PriceServiceImpl implements PriceService {
    private PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository){
        this.priceRepository = priceRepository;
    }

    @Override
    public Price fetchPrice(String id){
        Price price = priceRepository.fetchPrice(id);
        return price;
    }

    @Override
    public Price createPrice(PriceRequest priceRequest){
        ModelMapper mapper = new ModelMapper();
        Price price = mapper.map(priceRequest, Price.class);
        priceRepository.createPrice(price);
        return price;
    }

}
