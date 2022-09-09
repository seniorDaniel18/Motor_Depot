package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path WRITE_PATH = Paths.get("./trucks");

    public static void main(String[] args) {

        Truck[] trucks = {Truck.createTruck(1, "Renault Magnum", null, Status.BASE),
                Truck.createTruck(2, "Volvo", null, Status.BASE),
                Truck.createTruck(3, "DAF XT", null, Status.BASE)};

//        String allTrucks = gson.toJson(trucks);
//
//        writeFile(allTrucks);
//
//        System.out.println(readFile());

        System.out.println("---+-----------+-----------+-----------+");
        System.out.println(" id|   Truck   |   Driver  |   State   |");
        System.out.println("---+-----------+-----------+-----------+");
        System.out.println(" 1 |  Renault  |" + "           |" + "   " + Status.BASE + "    |");
        System.out.println("---+-----------+-----------+-----------+");
        System.out.println(" 2 |   Volvo   |" + "           |" + "   " + Status.BASE + "    |");
        System.out.println("---+-----------+-----------+-----------+");
        System.out.println(" 3 |   DAF XT  |" + "           |" + "   " + Status.BASE + "    |");
        System.out.println("---+-----------+-----------+-----------+");
    }

    public static void writeFile(String file) {

        Path write = Paths.get(String.valueOf(WRITE_PATH));

        try {
            Files.writeString(write, file, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
        } catch (IOException e) {
            e.getMessage();
        }
    }

    public static String readFile() {

        String json = "";

        try {
            FileReader reader = new FileReader(String.valueOf(WRITE_PATH));
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
