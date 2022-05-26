package com.geekbrains.market.client;

import com.geekbrains.market.modelproduct.Product;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.List;

public interface MarketProductApi {

    @GET("products")
    Call<List<Product>> getProducts();

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") Long id);

    @POST("products")
    Call<Product> postProduct(@Body Product product);

}
