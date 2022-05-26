package com.geekbrains;

import com.geekbrains.market.client.MarketProductService;
import com.geekbrains.market.modelproduct.Product;

public class MainMarket {
    public static void main(String[] args) {
        MarketProductService marketProductService = new MarketProductService();

        System.out.println(marketProductService.getProduct(22));

        Product product = new Product();
        product.setTitle("Recorder");
        product.setPrice(2500);
        product.setCategoryTitle("Electronic");

        Product createdProduct = marketProductService.createProduct(product);
        System.out.println(createdProduct);
    }
}
