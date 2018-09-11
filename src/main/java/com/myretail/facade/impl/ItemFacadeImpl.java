package com.myretail.facade.impl;

import com.myretail.facade.ItemFacade;
import com.myretail.rest.product.response.ItemResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.time.StopWatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class ItemFacadeImpl implements ItemFacade {

    private RestTemplate restTemplate;

    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder){
        return builder.build();
    }

    @Autowired
    public ItemFacadeImpl(RestTemplateBuilder builder) {
        this.restTemplate = restTemplate(builder);
    }

    @Override
    public ItemResponse getItem(String id){
        StopWatch watch = new StopWatch();
        watch.start();
        String itemUrl = "https://redsky.target.com/v2/pdp/tcin/"+id+"?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics";
        ItemResponse response = restTemplate.getForObject(itemUrl, ItemResponse.class);
        watch.stop();
        log.info("op={},status=OK,desc=successfully fetched item Details for the itemId {} in {} ms",
                "getItem", id, watch.getTime());
        return response;
    }

}
