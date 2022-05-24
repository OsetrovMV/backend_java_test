package com.geekbrains.spoonaccular;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static io.restassured.RestAssured.given;

public class IngredientsTest extends SpoonaccularTest {

    @Test
    void testIngredientsSearch() throws Exception {
        String actually = given()
                .param("query", "banana")
                .param("number", 5)
                .expect()
                .when()
                .get("food/ingredients/search")
                .body()
                .prettyPrint();

        String expected = getResource("expected.json");

        assertJson(expected, actually);
    }

}
