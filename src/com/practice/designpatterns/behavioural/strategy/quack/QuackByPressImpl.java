package com.practice.designpatterns.behavioural.strategy.quack;

public class QuackByPressImpl implements IQuackInterface{

    @Override
    public void quack() {
        System.out.println("PRESS ME !! QUACK !!!");
    }
}
