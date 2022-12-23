package com.practice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PubliserSubscriberUsingRentrantExample {

    /*
      Advantages of Rentrant locks is that
      1) we can lock in one method and unlock in other method
      2) we can take in multiple object locks and release them in any order
      like if there is locka,lockb,lockc
      3) lock can be called on same object multiple times as well
      4) constructor accepts boolean, this boolen is the fair flag which means
        that if the flag is true then it is fair lock if false it is unfair lock
        Rentrant lock maintains a queue to keep order of threads trying to acquire lock
        If fair falg is on then it makes sure first thread is served first i.e in order
        if flag is false then random threads get the lock
      5) There is a trylock method as well which returns boolean value
       if the thread gets the lock then it can do its desired task
       but if it doesnt get the lock it can continue with other task rather than it waiting to get the lock

     */
    private String message = null;
    static ReentrantLock lock = new ReentrantLock(true);

    Condition filled = lock.newCondition();
    Condition notFilled = lock.newCondition();

    public void publishMessage(String message) throws InterruptedException {
        lock.lock();
        try {
            while(this.message != null){
                System.out.println("Waiting for message to be read");
                notFilled.await();
            }
            this.message = message;
            System.out.println("Message :"+message+" published");
            filled.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public String cosumeMessage() throws InterruptedException {
        lock.lock();
        try {
            while(message == null){
                System.out.println("Waiting for message to be published");
                filled.await();
            }
            notFilled.signalAll();
            return message;
        }finally {
            message = null;
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        List<String>  messages = new ArrayList<>();
        messages.add("Rohan");
        messages.add("Dsouza");
        messages.add("Interview");

        PubliserSubscriberUsingRentrantExample publiserSubscriberExample = new PubliserSubscriberUsingRentrantExample();

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
