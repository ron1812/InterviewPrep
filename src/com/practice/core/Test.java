package com.practice.core;

public class Test{
    
    public void call(String s){
        System.out.printf("Hi from string");
    }
    
    public void call(Integer g){
        System.out.printf("Hi from integer");
    }

    public static void main(String[] args) {
        Test t=new Test();

        //Ambiguous Method call since both are Objects
        //t.call(null);
    }
}