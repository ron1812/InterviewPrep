package com.practice.designpatterns.behavioural.strategy.fly;

public class FlyHighImpl implements IFlyStrategy{
    @Override
    public void fly() {
        System.out.println("I can fly high");
    }
}
