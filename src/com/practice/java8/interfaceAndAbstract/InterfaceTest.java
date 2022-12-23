package com.practice.java8.interfaceAndAbstract;

public interface InterfaceTest {

    public static final Integer count = 1;

    void callInterface();
}

class Test {

    //Instance of interface cannot be created
    //The below code is creating an anonymous class that implements the above interface
    public static void main(String[] args) {

        InterfaceTest interfaceTest = () -> System.out.println("Calling interface");
        interfaceTest.callInterface();

        //Cannot change value of count
        //InterfaceTest.count = 2;
    }
}
