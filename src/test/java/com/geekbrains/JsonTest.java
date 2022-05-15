package com.geekbrains;

import com.google.gson.Gson;
import net.javacrumbs.jsonunit.JsonAssert;
import net.javacrumbs.jsonunit.core.Option;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Date;

public class JsonTest {

    @Test
    @DisplayName("Json body test")
    void testFirstWorkBody() throws IOException {
        String expected = getResourceAsString("expected.json");

        FirstWork actually = FirstWork.builder()
                .author("Mikhail")
                .text("Text")
                .createdAt(new Date())
                .build();

        JsonAssert.assertJsonEquals(
                expected,
                actually,
                JsonAssert.when(Option.IGNORING_ARRAY_ORDER)
        );

        printJson(actually);
    }

    public void printJson(Object o) {
        System.out.println(new Gson().toJson(o));
    }

    public String getResourceAsString(String resource) throws IOException {
        InputStream stream = getClass().getResourceAsStream(resource);
        assert stream != null;
        byte[] bytes = stream.readAllBytes();
        return new String(bytes, StandardCharsets.UTF_8);

    }

}
