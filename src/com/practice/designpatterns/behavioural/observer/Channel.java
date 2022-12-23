package com.practice.designpatterns.behavioural.observer;

import java.util.ArrayList;
import java.util.List;

public class Channel {

    private String title;
    private List<Subscriber> subscriberList =  new ArrayList<>();

    public void subscribe(Subscriber subscriber){
        subscriberList.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber){
        subscriberList.remove(subscriber);
    }

    public void notifySubscribers(){
        subscriberList.forEach(x -> x.update());
    }

    public void uploadVideo(String title){
        this.title = title;
        notifySubscribers();
    }

    public String getTitle(){
        return title;
    }

}
