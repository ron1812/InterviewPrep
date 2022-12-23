package com.practice.designpatterns.creational.singleton;

public enum SingletonEnum {

    INSTANCE;

    public static SingletonEnum getInstance(){
        return INSTANCE;
    }
}

class InstanceEnum {

    public static void main(String[] args) {

        SingletonEnum singleton = SingletonEnum.getInstance();
        SingletonEnum singleton1 = SingletonEnum.getInstance();
        SingletonEnum singleton2 = SingletonEnum.getInstance();

        System.out.println(singleton.hashCode());
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());

    }
}