package com.peaksoft;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class JsonUtils {

    public static void writeFile(String file, Path path) {

        try {
            Files.writeString(Paths.get(String.valueOf(path)), file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String readFile(Path path) {

        String json = "";

        try {
            FileReader reader = new FileReader(String.valueOf(path));
            int a;
            while ((a = reader.read()) != -1) {
                json += (char) a;
            }
        } catch (Exception e) {
            e.getMessage();
        }
        return json;
    }
}
