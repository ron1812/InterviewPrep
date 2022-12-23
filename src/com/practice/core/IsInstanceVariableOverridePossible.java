package com.practice.core;


//The is no overriding of instance variable in this case color
//Both color prints as parent color
public class IsInstanceVariableOverridePossible {

    public static void main(String[] args) {

        Parent c = new Child();
        System.out.println(c.color);
        c.print();

        Parent p = new Parent();
        System.out.println(p.color);
        p.print();

        Child c1 = new Child();
        System.out.println(c1.color);
        c1.print();
    }
}

class Parent {

    public String color = "Parent color";

    public void print(){
        System.out.println("parent method");
    }
}

class Child extends Parent{

    public String color = "Child color";

    public void print(){
        System.out.println("child method");
    }
}
