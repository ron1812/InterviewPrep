package com.practice.designpatterns.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;

// Eager loading
// meaning object created at boot up
public class SingletonEager {

    private static SingletonEager singleton = new SingletonEager();

    private SingletonEager(){

    }


    public static SingletonEager getInstance(){
        return singleton;
    }
}

class InstanceEager {

    public static void main(String[] args) {

        SingletonEager singleton = SingletonEager.getInstance();
        SingletonEager singleton1 = SingletonEager.getInstance();
        SingletonEager singleton2 = SingletonEager.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

    }
}