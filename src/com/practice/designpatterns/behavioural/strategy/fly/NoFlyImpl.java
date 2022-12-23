package com.practice.designpatterns.behavioural.strategy.fly;

public class NoFlyImpl implements IFlyStrategy{


    @Override
    public void fly() {
        System.out.println("I cant fly");
    }
}
