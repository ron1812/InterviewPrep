package com.practice.designpatterns.structural.decorator;

public class NonVegPizza implements Pizza{


    @Override
    public String getDescription() {
        return "NonVegPizza (350)";
    }

    @Override
    public Double getPrice() {
        return 350.00;
    }
}
