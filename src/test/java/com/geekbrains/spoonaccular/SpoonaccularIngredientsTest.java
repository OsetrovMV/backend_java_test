package com.geekbrains.spoonaccular;

import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;

import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SpoonaccularIngredientsTest {

    public void assertJson(Object expected, Object actually) {

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(Option.IGNORING_ARRAY_ORDER)
        );
    }

    public String getRosource(String name) throws Exception {
        String resource = getClass().getSimpleName() + "/" + name;
        InputStream inputStream = getClass().getResourceAsStream(resource);
        assert inputStream != null;
        byte[] bytes = inputStream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);
    }

    public File getFile(String name) {
        String resource = getClass().getSimpleName() + "/" + name;
        String file = getClass().getResource(resource).getFile();
        return new File(file);
    }
}
