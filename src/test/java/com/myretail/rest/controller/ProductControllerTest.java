package com.myretail.rest.controller;

import com.myretail.rest.aggregator.ProductAggregator;
import com.myretail.rest.product.controller.ProductController;
import com.myretail.service.price.PriceService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    ProductController productController;
    private MockMvc mockMvc;

    @Mock
    private PriceService priceService;
    @Mock
    ProductAggregator productAggregator;

    @Before
    public void setup() throws  Exception{
        productController = new ProductController(productAggregator, priceService);
        mockMvc = standaloneSetup(productController).build();
    }

    @Test
    public void testItemDetailsFetched() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/product/123").
                contentType(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).andReturn();
    }

    @Test
    public void testPriceCreatedSuccessfully() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/price/1234")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(
                        status().isOk()).andReturn();
    }

    private String inputPayload() {
        return "{\n" +
                "\t\"price\":\"500.50\",\n" +
                "\t\"currency\":\"USD\"\n" +
                "}";
    }

}
