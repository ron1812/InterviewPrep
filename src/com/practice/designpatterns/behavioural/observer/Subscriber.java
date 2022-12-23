package com.practice.designpatterns.behavioural.observer;

public class Subscriber {

    private String name;
    private Channel channel;

    public Subscriber(String name){
        this.name = name;
    }

    public void update() {
        System.out.println("Heyy " + name + ". New video uploaded : " + channel.getTitle());
    }

    public void subscribeChannel(Channel channel){
           this.channel = channel;
    }
}
