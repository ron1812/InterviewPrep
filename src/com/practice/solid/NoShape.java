package com.practice.solid;


public class NoShape implements Shape{
    @Override
    public double area() {
        throw new IllegalStateException("No shape does not have an area");
    }
}
