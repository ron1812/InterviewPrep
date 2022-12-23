package com.practice.designpatterns.structural.decorator;

public class VegPizza implements Pizza{
    @Override
    public String getDescription() {
        return "VegPizza (230)";
    }

    @Override
    public Double getPrice() {
        return 230.00;
    }
}
