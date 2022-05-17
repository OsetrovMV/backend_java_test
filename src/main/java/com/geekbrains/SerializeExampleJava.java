package com.geekbrains;

import java.io.*;
import java.util.Date;

public class SerializeExampleJava {

    private static void serializeFirstWork() {
        FirstWork firstWork = FirstWork.builder()
                .createdAt(new Date())
                .author("Mikhail")
                .text("First Work")
                .build();
        try (ObjectOutputStream os = new ObjectOutputStream(
                new FileOutputStream(new File("usertest.obj")))) {
            os.writeObject(firstWork);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deserializeFirstWork() {
        FirstWork firstWork = null;

        try (ObjectInputStream is = new ObjectInputStream(new FileInputStream("DataTest/usertest.obj"))) {

            firstWork = (FirstWork) is.readObject();

        } catch (Exception e) {

            e.printStackTrace();
        }

        System.out.println(firstWork);

    }

    public static void main(String[] args) {
        deserializeFirstWork();
    }
}


