package com.myretail.service.item.impl;

import com.myretail.facade.ItemFacade;
import com.myretail.rest.product.response.ItemResponse;
import com.myretail.rest.product.response.ProductResponse;
import com.myretail.service.item.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private ItemFacade itemFacade;

    @Autowired
    public ItemServiceImpl(ItemFacade itemFacade){
        this.itemFacade = itemFacade;
    }
    @Override
    public ProductResponse getProductDetails(String id) {
        ItemResponse item = itemFacade.getItem(id);
        ProductResponse product = new ProductResponse();
        product.setPartNumber(item.getProduct().getItem().getTcin());
        product.setTitle(item.getProduct().getItem().getProductDescription().getTitle());
        return product;
    }
}
