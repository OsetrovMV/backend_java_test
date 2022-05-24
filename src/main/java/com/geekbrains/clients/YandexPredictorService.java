package com.geekbrains.clients;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

import static com.geekbrains.clients.RetrofiCallExecutor.executeCall;

public class YandexPredictorService {

    private static final String API_KEY = "pdct.1.1.20220519T163438Z.6c825fe747c229c6.8d6978cc7ab4ffbe9723b87ecb4619b948608bdd";
    private final YandexPredictorApi api;
    private String e;

    public YandexPredictorService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(System.out::println);
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();

        api = new Retrofit.Builder()
                .baseUrl("https://predictor.yandex.net/api/v1/predict.json/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(YandexPredictorApi.class);
    }

    public List<String> getLangs() {
        return executeCall(api.getLangs(API_KEY));
    }

    public YandexPredictorResult complete(String q, String lang, Integer limit) {
        return executeCall(api.complete(API_KEY, q, lang, limit));
    }
}
