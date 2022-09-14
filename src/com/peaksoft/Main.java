package com.peaksoft;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.nio.file.Path;
import java.nio.file.Paths;

import static com.peaksoft.JsonUtils.*;
import static com.peaksoft.Truck.printInfoTrack;
import static com.peaksoft.TruckService.changeTruck;

public class Main {
    public static final GsonBuilder BUILDER = new GsonBuilder();
    public static final Gson gson = BUILDER.setPrettyPrinting().create();
    public static final Path PATH_TRUCK = Paths.get("./trucks");
    public static final Path PATH_DRIVER = Paths.get("./drivers");

    public static void main(String[] args) {

        Truck[] trucks = {Truck.createTruck(1, "Renault Magnum", " ", Status.BASE),
                Truck.createTruck(2, "Volvo", " ", Status.BASE),
                Truck.createTruck(3, "DAF XT", " ", Status.BASE)};

        Driver[] drivers = {Driver.createDriver(1, "Petr", ""),
                Driver.createDriver(2, "Askar", ""),
                Driver.createDriver(3, "Uson", "")};

//        JsonUtils.writeFile(gson.toJson(trucks), WRITE_PATH_TRUCK);
//        System.out.println(JsonUtils.readFile(WRITE_PATH_TRUCK));
//        JsonUtils.writeFile(gson.toJson(drivers), PATH_DRIVER);
//        System.out.println(JsonUtils.readFile(PATH_DRIVER));

        Truck[] truck = gson.fromJson(readFile(PATH_TRUCK), Truck[].class);
        printInfoTrack(PATH_TRUCK);
        Driver[] driver = gson.fromJson(readFile(PATH_DRIVER), Driver[].class);
        Driver.printInfoDriver(PATH_DRIVER);

        changeTruck(trucks, 1, drivers);



    }

}
