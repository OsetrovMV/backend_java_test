package com.geekbrains.spoonaccular.test;

import com.geekbrains.spoonaccular.SpoonaccularIngredientsTest;
import org.junit.jupiter.api.Test;

public class BaseIngredientsTest extends SpoonaccularIngredientsTest {

    @Test
    void test() throws Exception {
        System.out.println(getResource("text.txt"));
    }
}
