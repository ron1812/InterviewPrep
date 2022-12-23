package com.practice.designpatterns.behavioural.strategy;

import com.practice.designpatterns.behavioural.strategy.fly.IFlyStrategy;
import com.practice.designpatterns.behavioural.strategy.quack.IQuackInterface;

public class Duck {

    private final IQuackInterface quack;
    private final IFlyStrategy fly;

    public Duck(IQuackInterface quack, IFlyStrategy fly) {
        this.quack = quack;
        this.fly = fly;
    }

    public void quack(){
        this.quack.quack();
    }

    public void fly(){
        this.fly.fly();
    }

}
