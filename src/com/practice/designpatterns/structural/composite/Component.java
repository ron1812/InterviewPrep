package com.practice.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public interface Component {

    void getPrice();
}

class Leaf implements Component {

    String name;
    int price;

    public Leaf(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public void getPrice() {
        System.out.println("Name : "+ name + " Price : "+ price);
    }
}

class Composite implements Component {

    String name;
    List<Component> componentList = new ArrayList<>();

    public Composite(String name) {
        this.name = name;
    }

    public void addComponent(Component component){
        componentList.add(component);
    }
    @Override
    public void getPrice() {

        for(Component component : componentList){
            System.out.println("Composite Name : "+ name);
            component.getPrice();
        }
    }
}
