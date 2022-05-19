package com.complexible.lorem_ipsum_test;

import java.awt.*;

public class Car {
    public String brand;
    public String plateNumber;
    public Color color;

    public Car(String brand) {
        this.brand = brand;
    }

    public Car(String brand, String plateNumber) {
        this.brand = brand;
        this.plateNumber = plateNumber;
    }

    public Car(String brand, String plateNumber, Color color) {
        this.brand = brand;
        this.plateNumber = plateNumber;
        this.color = color;
    }
}
