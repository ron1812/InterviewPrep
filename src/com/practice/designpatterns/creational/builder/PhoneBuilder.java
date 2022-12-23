package com.practice.designpatterns.creational.builder;

public class PhoneBuilder {

    private String os;
    private int ram;
    private String screen;
    private int battery;

    public PhoneBuilder setOs(String os) {
        this.os = os;
        return this;
    }

    public PhoneBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public PhoneBuilder setScreen(String screen) {
        this.screen = screen;
        return this;
    }

    public PhoneBuilder setBattery(int battery) {
        this.battery = battery;
        return this;
    }

    public Phone getPhone(){
        return new Phone(os,ram,screen,battery);
    }
}
