package com.practice.multithreading;

import java.util.ArrayList;
import java.util.List;

public class PubliserSubscriberExample {

    private String message = "";
    private volatile Boolean isFilled = false;

    public void publishMessage(String message) throws InterruptedException {
        synchronized (this) {
            while(isFilled){
                System.out.println("Waiting for message to be read");
                wait();
            }
            this.message = message;
            System.out.println("Message :"+message+" published");
            isFilled = true;
            notifyAll();
        }
    }

    public String cosumeMessage() throws InterruptedException {
        synchronized (this) {
            while(!isFilled){
                System.out.println("Waiting for message to be published");
                wait();
            }
            isFilled = false;
            notifyAll();
            return message;
        }
    }

    public static void main(String[] args) {
        List<String>  messages = new ArrayList<>();
        messages.add("Rohan");
        messages.add("Dsouza");
        messages.add("Interview");

        PubliserSubscriberExample publiserSubscriberExample = new PubliserSubscriberExample();

        Thread publish = new Thread(() -> {
            for(int i = 0; i<messages.size() ; i++){
                try {
                    publiserSubscriberExample.publishMessage(messages.get(i));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consume = new Thread(() -> {
            for(int i = 0; i<messages.size() ; i++){
                try {
                    System.out.println("Message read "+publiserSubscriberExample.cosumeMessage());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        publish.start();
        consume.start();
    }
}
