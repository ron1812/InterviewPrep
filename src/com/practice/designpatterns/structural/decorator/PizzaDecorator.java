package com.practice.designpatterns.structural.decorator;

public abstract class PizzaDecorator implements Pizza {

    @Override
    public String getDescription() {
        return "Toppings";
    }
}
