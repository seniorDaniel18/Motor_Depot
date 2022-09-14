package com.peaksoft;

import java.util.Scanner;

public class TruckService {

    static Scanner sc = new Scanner(System.in);

    static String truckName;
    static String driverName = null;
    static String dr;
    static Driver driver = new Driver();

    public static void changeTruck(Truck[] trucks, int truckId, Driver[] drivers) {

        for (int i = 0; i < trucks.length; i++) {
            if (trucks[i].getId() == truckId) {
               if(trucks[i].getDriverName() == null)  {
                   dr = " ";
               } else {
                   dr = trucks[i].getDriverName();
               }
                truckName = trucks[i].getName();
                System.out.println("#: " + trucks[i].getId());
                System.out.println("Truck: " + trucks[i].getName());
                System.out.println("Driver:  " + dr);
                System.out.println("Status: " + trucks[i].getStatus());

                if (trucks[i].getStatus().equals(Status.BASE)) {
                    System.out.println("Отправить в путь - нажмите 1");
                    System.out.println("Отправить на ремонт - нажмите 2");
                    System.out.println("Выбрать водителя - нажмите 3");

                    int a = sc.nextInt();

                    if (a == 3) {
                        changeDriver(drivers, trucks[i]);
                        trucks[i].setDriver(driver.getName());
                        System.out.println("Отправить в путь - нажмите 1 \n Завершить - нажмите 0");

                        a = sc.nextInt();

                        if (a == 1) {
                            methodDriving(truckName, driverName);
                            trucks[i].setStatus(Status.ROUTE);
                        } else if (a == 0) {
                            System.out.println("Грузовик остался на базе");
                            break;
                        }
                    } else if (a == 1) {
                        System.out.println("Выберите водителя");
                        changeDriver(drivers, trucks[i]);
                        trucks[i].setDriver(driver.getName());
                        methodDriving(truckName, driverName);
                        trucks[i].setStatus(Status.ROUTE);
                    } else if (a == 2) {
                        repair(truckName);
                        trucks[i].setStatus(Status.REPAIR);
                    }
                } else if (trucks[i].getStatus().equals(Status.ROUTE)) {
                    System.out.println("Грузовик " + truckName + " уже в пути");
                } else if (trucks[i].getStatus().equals(Status.REPAIR)) {
                    System.out.println("Грузовик " + truckName + " на ремонте");
                }
            }
        }

        if (truckId > trucks.length) {
            throw new RuntimeException("Введите id грузовика корректно ");
        }

    }

    private static void changeDriver(Driver[] drivers, Truck truck) {

        for (int i = 0; i < drivers.length; i++) {
            if (drivers[i].getId() == truck.getId()) {
                driverName = drivers[i].getName();
                driver = drivers[i];
            }
        }
        System.out.println("У грузовика " + truckName + " водитель " + driverName);
    }

    private static void methodDriving(String truck, String driver) {

        System.out.println("Грузовик " + truck + " в пути. За рулём " + driver);
    }

    private static void repair(String truck) {

        System.out.println("Грузовик " + truck + " на ремонте");

    }


}
