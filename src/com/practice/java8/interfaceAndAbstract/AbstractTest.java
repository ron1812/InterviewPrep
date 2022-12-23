package com.practice.java8.interfaceAndAbstract;

public abstract class AbstractTest {

    public AbstractTest(){
        System.out.println("Creating instance of anonymous class");
    }

    public void printSomething(){
        System.out.println("Print something");
    }

    public abstract void implementSomthing();
}

class TestAbstractInstance{

    public static void main(String[] args) {

        AbstractTest abstractTest = new AbstractTest() {
            @Override
            public void implementSomthing() {
                System.out.println("Implemented something");
            }
        };

        abstractTest.printSomething();

        abstractTest.implementSomthing();
    }
}
