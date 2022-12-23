package com.practice.designpatterns.behavioural.strategy.fly;

public class FlyLowImpl implements IFlyStrategy{
    @Override
    public void fly() {
        System.out.println("I can fly low");
    }
}
