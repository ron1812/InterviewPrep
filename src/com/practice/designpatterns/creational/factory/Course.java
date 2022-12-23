package com.practice.designpatterns.creational.factory;

import java.util.ArrayList;
import java.util.List;

public abstract class Course {

    List<String> modules = new ArrayList<>();

    public Course(String name){
        System.out.println("Inside Course abstract class to create instance of "+name);
        this.createCourse();
    }

    public List<String> getModules(){
        return modules;
    }

    public abstract void createCourse();
}
