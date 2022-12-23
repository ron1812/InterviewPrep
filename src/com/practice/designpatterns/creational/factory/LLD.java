package com.practice.designpatterns.creational.factory;

public class LLD extends Course{

    public LLD() {
        super("lld");
    }

    @Override
    public void createCourse() {
        modules.add("Demo");
        modules.add("Exercise");
        modules.add("Start LLD Training");
    }
}
