package com.geekbrains.spoonaccular;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class RecipesTest {
    private static final String API_KEY = "e4d4b696bc514c73adff88732a76a428";

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = "https://api.spoonacular.com/recipes/";
    }

    @Test
    void testComputeIngredientAmount() throws IOException {
        given()
                .log()
                .all()
                .param("apiKey", API_KEY)
                .pathParam("id", 69095)
                .expect()
                .log()
                .body()
                .body("sweetness", is(48.15F))
                .body("saltiness", is(45.29F))
                .body("sourness", is(15.6F))
                .body("bitterness", is(19.17F))
                .body("savoriness", is(26.45F))
                .body("fattiness", is(100.0F))
                .body("spiciness", is(0.0F))
                .when()
                .get("{id}/tasteWidget.json");
    }

    public String getResourceAsString(String resource) throws IOException {
        InputStream stream = getClass().getResourceAsStream(resource);
        assert stream != null;
        byte[] bytes = stream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }
}
