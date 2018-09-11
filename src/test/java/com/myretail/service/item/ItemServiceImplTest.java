package com.myretail.service.item;

import com.myretail.facade.ItemFacade;
import com.myretail.facade.impl.ItemFacadeImpl;
import com.myretail.rest.product.response.ItemResponse;
import com.myretail.rest.product.response.ProductResponse;
import com.myretail.service.item.impl.ItemServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.AssertTrue;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceImplTest {

    ItemServiceImpl itemServiceImpl;

    @Mock
    ItemFacade facade;


    @Before
    public void setUp() throws Exception {
        itemServiceImpl = new ItemServiceImpl(facade);
    }

    @Test
    public void testGetProductDetails() throws  Exception {
        ItemResponse item = getItemDetails();

        when(facade.getItem(any())).thenReturn(item);
        ProductResponse product = itemServiceImpl.getProductDetails("1234567");

        Assert.assertEquals(item.getProduct().getItem().getTcin(), product.getPartNumber());
        Assert.assertEquals(item.getProduct().getItem().getProductDescription().getTitle(),product.getTitle());

    }

    protected ItemResponse getItemDetails() throws  Exception {
        ItemResponse response = new ItemResponse();
        ItemResponse.Product product = new ItemResponse.Product();
        ItemResponse.Item item = new ItemResponse.Item();
        ItemResponse.ProductDescription productDescription = new ItemResponse.ProductDescription();

        productDescription.setTitle("IPAD");

        item.setTcin("1234567");
        item.setProductDescription(productDescription);

        product.setItem(item);

        response.setProduct(product);

        return response;
    }
}
