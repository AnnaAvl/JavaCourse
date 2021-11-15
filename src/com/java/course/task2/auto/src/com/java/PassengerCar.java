package com.java;

public class PassengerCar extends Car {
    int numberOfSeats;

    public PassengerCar(String model, int maxSpeed, int weight, String engineType, int numberOfSeats) throws Throwable {
        super(model, maxSpeed, weight, engineType);
        if (numberOfSeats > 9) {
            throw new Throwable("Number of seats must be less then 9");
        } else {
            this.numberOfSeats = numberOfSeats;
        }
    }
}
