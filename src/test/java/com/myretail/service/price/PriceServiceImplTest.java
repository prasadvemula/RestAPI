package com.myretail.service.price;

import com.myretail.data.respository.entity.Price;
import com.myretail.data.respository.price.PriceRepository;
import com.myretail.rest.product.request.PriceRequest;
import com.myretail.service.price.impl.PriceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    private PriceServiceImpl priceServiceImpl;

    @Before
    public void setup() throws Exception{
        priceServiceImpl = new PriceServiceImpl(priceRepository);
    }

    @Test
    public void testGetPrice() throws  Exception{
        Price response = getPriceResponse();
        when(priceRepository.fetchPrice(any())).thenReturn(response);
        Price p = priceServiceImpl.fetchPrice("123");
        Assert.assertEquals(p.getId(), response.getId());
        Assert.assertEquals(p.getPrice(), response.getPrice());
        Assert.assertEquals(p.getCurrency(), response.getCurrency());
    }

    @Test
    public void testCreatePrice() throws Exception {
        PriceRequest request = getPriceRequest();
        Price response = getPriceResponse();
        when(priceRepository.createPrice(any())).thenReturn(response);
        Price p = priceServiceImpl.createPrice(request);
        Assert.assertEquals(p.getId(), response.getId());
        Assert.assertEquals(p.getCurrency(), response.getCurrency());
        Assert.assertEquals(p.getPrice(), response.getPrice());
    }

    protected Price getPriceResponse() {
        Price price = new Price();
        price.setId("9876");
        price.setPrice("26.99");
        price.setCurrency("USD");
        return price;
    }

    protected PriceRequest getPriceRequest() {
        PriceRequest price = new PriceRequest();
        price.setId("9876");
        price.setPrice("26.99");
        price.setCurrency("USD");
        return price;
    }

}
