package com.myretail.rest.product.controller;


import com.myretail.data.respository.entity.Price;
import com.myretail.rest.aggregator.ProductAggregator;
import com.myretail.rest.product.request.PriceRequest;
import com.myretail.rest.product.response.ProductResponse;
import com.myretail.service.item.ItemService;
import com.myretail.service.price.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class ProductController {

    private PriceService priceService;
    private ProductAggregator productAggregator;

    @Autowired
    public ProductController(ProductAggregator productAggregator, PriceService priceService){
        this.productAggregator = productAggregator;
        this.priceService = priceService;
    }

    @RequestMapping(value ="/product/{id}", method = RequestMethod.GET)
    public ProductResponse getProductDetails(@PathVariable String id) {
        StopWatch watch = new StopWatch();
        watch.start();
        ProductResponse response= productAggregator.fetchProduct(id);
        watch.stop();
        log.info("op={},status=OK,desc=successfully fetched item Details for the itemId {} in {} ms",
                "Item Details", id, watch.getTime());
        return response;
    }

    @RequestMapping(value = "/price/{id}", method = RequestMethod.POST)
    public Price createPriceById(@PathVariable String id, @RequestBody (required = false)PriceRequest request) {
        StopWatch watch = new StopWatch();
        watch.start();
        request.setId(id);
        Price price = priceService.createPrice(request);
        watch.stop();
        log.info("op={},status=OK,desc=successfully created price for the itemId {} in {} ms",
                "create price", id, watch.getTime());
        return price;
    }

    @RequestMapping(value = "/price/{id}", method = RequestMethod.GET)
    public Price getPrice(@PathVariable String id) {
        StopWatch watch = new StopWatch();
        watch.start();
        Price price = priceService.fetchPrice(id);
        watch.stop();
        log.info("op={},status=OK,desc=successfully fetched price Details for the itemId {} in {} ms",
                "Item Details", id, watch.getTime());
        return price;
    }
}
