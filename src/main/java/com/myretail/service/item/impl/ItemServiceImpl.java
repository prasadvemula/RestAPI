package com.myretail.service.item.impl;

import com.myretail.facade.ItemFacade;
import com.myretail.rest.product.response.ItemResponse;
import com.myretail.rest.product.response.ProductResponse;
import com.myretail.service.item.ItemService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemFacade itemFacade;

    @Override
    public ProductResponse getProductDetails(String id) {
        ItemResponse item = itemFacade.getItem(id);
        ProductResponse product = new ProductResponse();
        if (null != item && null != item.getProduct() && null != item.getProduct().getItem()) {
            product.setPartNumber(item.getProduct().getItem().getTcin());
            if (null != item.getProduct().getItem().getProductDescription()) {
                product.setTitle(item.getProduct().getItem().getProductDescription().getTitle());
            }
        }
        return product;
    }
}
