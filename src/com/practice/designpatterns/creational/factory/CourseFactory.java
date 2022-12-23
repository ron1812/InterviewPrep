package com.practice.designpatterns.creational.factory;

public class CourseFactory {

    public static Course getCourse(String course){
        switch (course){
            case "LLD":
                return new LLD();
            case "HLD":
                return new HLD();
            default:
                throw  new IllegalArgumentException("Illegal course type passed");
        }
    }
}
