package com.practice.designpatterns.creational.singleton;

// This is lazy loaded and thread safe and less verbose
// Also know as Holder pattern
public class SingletonStatic {

    private static class Holder {
        static final SingletonStatic singleton = new SingletonStatic();
    }

    private SingletonStatic(){

    }


    public static SingletonStatic getInstance(){
        return Holder.singleton;
    }
}

class InstanceStatic {

    public static void main(String[] args) {

        SingletonStatic singleton = SingletonStatic.getInstance();
        SingletonStatic singleton1 = SingletonStatic.getInstance();
        SingletonStatic singleton2 = SingletonStatic.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

    }
}