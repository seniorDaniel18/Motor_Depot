package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;

import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.Main.gson;


public class Truck {

    private int id;
    private String name;
    private Status status;
    private Driver driver;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }


    public static Truck createTruck(int id, String name, Driver driver, Status status) {

        Truck truck = new Truck();

        truck.id = id;
        truck.name = name;
        truck.driver = driver;
        truck.status = status;

        return truck;

    }

    public static void printInfoTrack(Path path) {
        System.out.println("\n\tINFO ABOUT TRUCKS\n" +
                "---------------------------------------");
        System.out.printf("%-1s%-20s%-10s%-10s%n", "#", "| Bus", "| Driver", "| State");
        Truck[] trucks = gson.fromJson(readFile(path), Truck[].class);
        System.out.println("---------------------------------------");
        for (Truck truck : trucks) {
            System.out.printf("%-1s", truck.getId());
            System.out.printf("| %-18s", truck.getName());
            System.out.printf("| %-8s", truck.getDriver());
            System.out.printf("| on %-10s", truck.getStatus());
            System.out.println("\n---------------------------------------");
        }
    }

}
