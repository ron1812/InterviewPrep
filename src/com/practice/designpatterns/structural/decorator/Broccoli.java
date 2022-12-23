package com.practice.designpatterns.structural.decorator;

public class Broccoli extends PizzaDecorator {

    public final Pizza pizza;

    public Broccoli(Pizza p){
        this.pizza = p;
    }

    @Override
    public String getDescription() {
        return pizza.getDescription()+", Broccoli (9.25)";
    }

    @Override
    public Double getPrice() {
        return pizza.getPrice()+9.25;
    }
}
