package com.peaksoft;

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

    @Override
    public String toString() {
        return "Truck{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", driver=" + driver +
                '}';
    }
}
