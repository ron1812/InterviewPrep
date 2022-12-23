package com.practice.designpatterns.creational.factory;

public class FactoryExample {

    public static void main(String[] args) {
        Course hld = CourseFactory.getCourse("HLD");
        Course lld = CourseFactory.getCourse("LLD");

        System.out.println("******************* HLD ***************************");
        hld.getModules().forEach(x -> System.out.println("HLD COURSE MODULE "+x));

        System.out.println("******************* LLD ***************************");
        lld.getModules().forEach(x -> System.out.println("LLD COURSE MODULE "+x));
    }
}
