package com.geekbrains.market.client;

import com.geekbrains.market.modelproduct.Product;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.geekbrains.clients.RetrofiCallExecutor.executeCall;

public class MarketProductService {

    private final MarketProductApi api;

    public MarketProductService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(System.out::println);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        api = new Retrofit.Builder()
                .baseUrl("https://minimarket1.herokuapp.com/market/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(MarketProductApi.class);
    }

    public List<Product> getProducts() {
        return executeCall(api.getProducts());
    }

    public Product getProduct(long id) {
        return executeCall(api.getProduct(id));
    }

    public Product createProduct(Product product) {
        return executeCall(api.postProduct(product));
    }

}
