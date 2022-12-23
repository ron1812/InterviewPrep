package com.practice.designpatterns.creational.factory;

public class HLD extends Course{

    public HLD() {
        super("hld");
    }

    @Override
    public void createCourse() {
        modules.add("Demo");
        modules.add("Intro");
        modules.add("Start HLD Training");
    }
}
