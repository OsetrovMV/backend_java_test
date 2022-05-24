package com.geekbrains.spoonaccular;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import org.junit.jupiter.api.BeforeAll;

public class SpoonaccularTest extends SpoonaccularIngredientsTest {

    private static final String API_KEY = "e4d4b696bc514c73adff88732a76a428";

    @BeforeAll
    static void beforeAll() {

        RestAssured.baseURI = "https://api.spoonacular.com/";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .addQueryParam("apiKey", API_KEY)
                .log(LogDetail.ALL)
                .build();

        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .log(LogDetail.BODY)
                .build();

    }

}
