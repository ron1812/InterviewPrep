package com.practice.designpatterns.creational.builder;

public class Phone {

    private String os;
    private int ram;
    private String screen;
    private int battery;

    @Override
    public String toString() {
        return "Phone{" +
                "os='" + os + '\'' +
                ", ram=" + ram +
                ", screen='" + screen + '\'' +
                ", battery=" + battery +
                '}';
    }

    public Phone(String os, int ram, String screen, int battery) {
        this.os = os;
        this.ram = ram;
        this.screen = screen;
        this.battery = battery;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public int getBattery() {
        return battery;
    }

    public void setBattery(int battery) {
        this.battery = battery;
    }
}
