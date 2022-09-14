package com.peaksoft;

import java.nio.file.Path;

import static com.peaksoft.JsonUtils.readFile;
import static com.peaksoft.Main.gson;

public class Driver {

    private int id;
    private String name;
    private String truck;

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

    public String getTruck() {
        return truck;
    }

    public void setTruck(String truck) {
        this.truck = truck;
    }

    public static Driver createDriver(int id, String name, String truck) {

        Driver driver = new Driver();

        driver.id = id;
        driver.name = name;
        driver.truck = truck;

        return driver;
    }

   public static void printInfoDriver(Path path) {
       System.out.println("\n\t INFO ABOUT DRIVERS\n" +
               "-----------------------------");
       System.out.printf("%-1s%-10s%-20s%n", "#", "| Driver", "| Bus");
       Driver[] driver = gson.fromJson(readFile(path), Driver[].class);
       System.out.println("-----------------------------");
       for(Driver drive : driver) {
           System.out.printf("%-1s", drive.getId());
           System.out.printf("| %-8s", drive.getName());
           System.out.printf("| %-18s", drive.getTruck());
           System.out.println("\n-----------------------------");
       }
   }
}
