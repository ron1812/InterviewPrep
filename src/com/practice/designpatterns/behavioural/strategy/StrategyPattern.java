package com.practice.designpatterns.behavioural.strategy;

import com.practice.designpatterns.behavioural.strategy.fly.FlyHighImpl;
import com.practice.designpatterns.behavioural.strategy.fly.FlyLowImpl;
import com.practice.designpatterns.behavioural.strategy.fly.NoFlyImpl;
import com.practice.designpatterns.behavioural.strategy.quack.QuackByPressImpl;
import com.practice.designpatterns.behavioural.strategy.quack.QuackTwiceImpl;

public class StrategyPattern {

    /*
       Lets take an example of Duck and behaviour like fly and quack
       If we follow a pattern to keep Duck as an interface and get it implemented by WildDuck,RubberDuck,CityDuck

                           Duck
                            |
             WildDuck   RubberDuck   CityDuck

       and lets assume wildduck and cityDuck has the same behaviour of flying we would require to repeat the implementation
       in both the classes so to solve this we can use Strategy pattern

       The Strategy Design Pattern defines a family of algorithms, encapsulating each one, and making them interchangeable. Strategy
       lets the algorithm vary independently from the clients that use it.

       We can create interfaces of fly and quack behaviour and inject whichever is required for respective ducks
       in concrete class

     */
    public static void main(String[] args) {
        //The below implementations are strategies that can be injected into duck class
        QuackTwiceImpl quackTwice = new QuackTwiceImpl();
        QuackByPressImpl quackByPress = new QuackByPressImpl();
        FlyHighImpl flyHigh = new FlyHighImpl();
        FlyLowImpl flyLow = new FlyLowImpl();
        NoFlyImpl noFly = new NoFlyImpl();

        Duck wildDuck = new Duck(quackTwice,flyHigh);
        Duck rubberDuck = new Duck(quackByPress,noFly);
        Duck cityDuck = new Duck(quackTwice,flyLow);

        System.out.println("WILD DUCK");
        wildDuck.fly();
        wildDuck.quack();

        System.out.println("RUBBER DUCK");
        rubberDuck.fly();
        rubberDuck.quack();

        System.out.println("CITY DUCK");
        cityDuck.fly();
        cityDuck.quack();
    }
}
