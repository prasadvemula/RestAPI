package com.myretail.rest.aggregator.Impl;

import com.myretail.data.respository.entity.Price;
import com.myretail.rest.aggregator.ProductAggregator;
import com.myretail.rest.product.response.ProductResponse;
import com.myretail.service.item.ItemService;
import com.myretail.service.price.PriceService;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import io.reactivex.Observable;


@Service
public class ProductAggregatorImpl implements ProductAggregator {

    private PriceService priceService;
    private ItemService itemService;

    @Autowired
    public ProductAggregatorImpl(ItemService itemService, PriceService priceService){
        this.itemService = itemService;
        this.priceService = priceService;
    }

    @Override
    public ProductResponse fetchProduct(String id) {
        Observable<ProductResponse> itemObservable
                = Observable.fromCallable(() -> itemService.getProductDetails(id)).subscribeOn(Schedulers.io()).observeOn(Schedulers.single());
        Observable<Price> priceObservable = Observable.fromCallable(() -> priceService.fetchPrice(id)).subscribeOn((Schedulers.io())).observeOn((Schedulers.single()));


        itemObservable.onErrorReturn(throwable -> new ProductResponse());

        priceObservable.onErrorReturn(throwable -> new Price());

        ProductResponse product = Observable.zip(itemObservable, priceObservable, this::aggregate).blockingFirst();


        return product;
    }

    public ProductResponse aggregate(ProductResponse product, Price price) {
        if(price != null) {
            product.setPrice(price.getPrice());
        }

        return product;
    }
}
