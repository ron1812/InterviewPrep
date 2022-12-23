package com.practice.designpatterns.structural.decorator;

public class Cheese extends PizzaDecorator {

    private final Pizza pizza;

    public Cheese(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", Cheese (20.72)";
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice()+20.72;
    }
}
