package com.geekbrains.spoonaccular;

import io.restassured.RestAssured;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;

public class IngredientsTest {

    private static final String API_KEY = "e4d4b696bc514c73adff88732a76a428";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com/food/ingredients/";
    }

    @Test
    void testIngredientsSearch() throws IOException {
        String actually = given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .param("query", "banana")
                .param("number", 5)
                .expect()
                .log()
                .body()
                .when()
                .get("search")
                .body()
                .prettyPrint();

        String expected = getResourceAsString("testIngredientsTest/expected.json");

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(Option.IGNORING_ARRAY_ORDER)
        );
    }

    public String getResourceAsString(String resource) throws IOException {
        InputStream stream = getClass().getResourceAsStream(resource);
        assert stream != null;
        byte[] bytes = stream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
