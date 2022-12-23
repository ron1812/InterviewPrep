package com.practice.solid;

public class Cube implements Shape,ThreeDShape{

    @Override
    public double area() {
        return 10;
    }

    @Override
    public double volume() {
        return 100;
    }
}
