package com.geekbrains;

import com.google.gson.Gson;

import java.util.Date;

public class SerializeExampleJson {

    private static final Gson gson = new Gson();

    private static <T> String getJson(T object) {
        return gson.toJson(object);
    }

    private static <T> T getObject(String json, Class<T> clazz) {
        return gson.fromJson(json, clazz);
    }

    public static void main(String[] args) {
        FirstWork firstWork = FirstWork.builder()
                .createdAt(new Date())
                .author("Mikhail")
                .text("First Work")
                .build();

        String json = getJson(firstWork);
        System.out.println(json);
        System.out.println(getObject(json, FirstWork.class));

    }
}
