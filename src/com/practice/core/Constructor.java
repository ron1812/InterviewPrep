package com.practice.core;

public class Constructor {

    Constructor(Integer object){

        System.out.println("Inside Parent "+object);
    }
}

class ChildConstructor extends Constructor{

    ChildConstructor(Object object) {

        super((int)object);
        System.out.println("Inside Child "+object);
    }
}

class TestConstructor {

    public static void main(String[] args) {
        Constructor con = new ChildConstructor(1000);
    }
}