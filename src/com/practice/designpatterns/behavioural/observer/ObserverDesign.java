package com.practice.designpatterns.behavioural.observer;

public class ObserverDesign {

    // Consider this pattern to be used by youtube
    // One change here would be that subscriber can subscribe to only one channel
    // whereas channel can have multiple subscribers
    public static void main(String[] args) {
        Channel back2basics = new Channel();

        Subscriber s1 = new Subscriber("Rohan");
        Subscriber s2 = new Subscriber("Ankit");
        Subscriber s3 = new Subscriber("Jessy");
        Subscriber s4 = new Subscriber("Neil");
        Subscriber s5 = new Subscriber("Rachael");

        s1.subscribeChannel(back2basics);
        s2.subscribeChannel(back2basics);
        s3.subscribeChannel(back2basics);
        s4.subscribeChannel(back2basics);
        s5.subscribeChannel(back2basics);

        back2basics.subscribe(s1);
        back2basics.subscribe(s2);
        back2basics.subscribe(s3);
        back2basics.subscribe(s4);
        back2basics.subscribe(s5);

        back2basics.unsubscribe(s3);

        back2basics.uploadVideo("Learn Design Patterns ");
    }
}
