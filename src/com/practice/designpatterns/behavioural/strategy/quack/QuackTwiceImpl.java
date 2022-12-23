package com.practice.designpatterns.behavioural.strategy.quack;

public class QuackTwiceImpl implements IQuackInterface{

    @Override
    public void quack() {
        System.out.println("QUACK !!!! QUACK !!!");
    }
}
