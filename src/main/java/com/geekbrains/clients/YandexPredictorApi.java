package com.geekbrains.clients;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface YandexPredictorApi {

    @GET("getLangs")
    Call<List<String>> getLangs(@Query("key") String key);

    @GET("complete")
    Call<YandexPredictorResult> complete(
            @Query("key") String key,
            @Query("q") String q,
            @Query("lang") String lang,
            @Query("limit") Integer limit
    );

}
