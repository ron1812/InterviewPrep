package com.practice.designpatterns.structural.decorator;

public class TestDecoratorPattern {

    /*
    This design pattern is like a gift wrapper on the base class

                           Pizza(interface)
                               |
             Non Veg(c)       Veg(c)       Decorator(abstract)
                                                   |
                                          brocolli       cheese

      Pizza can be added with many toppings .These topping are considered as decorator
      Decorator class have IS A and HAS A relation with Pizza class
      which means it is a child of Parent interface as well have Parent Object/instance set in constructor
      This allows you to getPrice of the pizza along with any toppings added to it multiple times
     */
    public static void main(String[] args) {
        Pizza nonVegPizza = new NonVegPizza();

        nonVegPizza = new Broccoli(nonVegPizza);
        nonVegPizza = new Cheese(nonVegPizza);

        System.out.println("Non veg pizza Description : "+nonVegPizza.getDescription());
        System.out.println("Non veg pizza Price : "+nonVegPizza.getPrice());

        Pizza vegPizza = new VegPizza();

        vegPizza = new Broccoli(vegPizza);
        vegPizza = new Cheese(vegPizza);

        System.out.println("veg pizza Description : "+vegPizza.getDescription());
        System.out.println("veg pizza Price : "+vegPizza.getPrice());
    }
}
