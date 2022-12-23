package com.practice.core;

// Static block is called before the main method is called
// instance method is called after object creation and before constructor call
public class StaticAndInstanceBlock {

    static {
        System.out.println("I am static block 1");
    }

    static {
        System.out.println("I am static block 2");
    }

    {
        System.out.println("I am instance block 1");
    }
    {
        System.out.println("I am instance block 2");
    }

    public StaticAndInstanceBlock(){
        System.out.println("I am constructor");
    }

    public static void main(String[] args) {
        System.out.println("I am Main method");

        StaticAndInstanceBlock staticAndInstanceBlock =  new StaticAndInstanceBlock();
    }
}
