package com.practice.core;

public class A{

    public static void print(){
        System.out.println("A");
    }

    public void print1(){
        System.out.println("Non Static A");
    }
}

class B extends A{

    public static void print(){
        System.out.println("Test B");
    }

    public void print1(){
        System.out.println("Non Static Test B");
    }
}

class Mainy{

    public static void main(String[] args) {
        A obj=new B();

        obj.print();   // A
        obj.print1();  // Non static Test B

        A obj1=null;
        obj1.print();  // A

        B obj2=new B();
        
        obj2.print();  //test b
        obj2.print1(); //Non static Test B
    }
 }