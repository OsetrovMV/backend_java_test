package com.geekbrains.spoonaccular;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

public class ImageFoodTest extends SpoonaccularTest {

    @Test
    void testBananClassification() {
        given()
                .multiPart(getFile("banana.jpeg"))
                .expect()
                .body("category", is("banana"))
                .body("probability", greaterThan(0.5F))
                .when()
                .post("food/images/classify");

    }
}
