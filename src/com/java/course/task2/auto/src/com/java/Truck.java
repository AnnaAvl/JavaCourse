package com.java;

public class Truck extends Car {
    String truckType;
    int numberOfAxes;
    int loadCapacity;

    public Truck(String model, int maxSpeed, int weight, String engineType, String truckType, int numberOfAxes, int loadCapacity) {
        super(model, maxSpeed, weight, engineType);
        this.truckType = truckType;
        this.numberOfAxes = numberOfAxes;
        this.loadCapacity = loadCapacity;
    }

    public String getTruckType() {
        return truckType;
    }

    @Override
    public String toString() {
        return truckType;
    }
}
