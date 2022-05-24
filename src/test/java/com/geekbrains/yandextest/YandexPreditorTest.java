package com.geekbrains.yandextest;

import com.geekbrains.clients.YandexPredictorResult;
import com.geekbrains.clients.YandexPredictorService;
import com.geekbrains.spoonaccular.SpoonaccularIngredientsTest;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;


public class YandexPreditorTest extends SpoonaccularIngredientsTest {

    private static YandexPredictorService service;

    @BeforeAll
    static void beforAll() {

        service = new YandexPredictorService();
    }

    @Test
    void testGetLangs() throws Exception {
        List<String> langs = service.getLangs();
        assertJson(getResource("langs.json"), langs);
    }

    @Test
    void testPrediction() throws Exception {
        YandexPredictorResult result = service.complete("Hello wo", "en", 5);
        assertJson(getResource("complete.json"), result);
    }
}
