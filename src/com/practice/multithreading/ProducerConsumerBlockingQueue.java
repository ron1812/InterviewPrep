package com.practice.multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class ProducerConsumerBlockingQueue {

    /*
    ArrayBlockingQueue is bounded, blocking queue that stores the elements internally backed by an array.

    Bounded means it will have a fixed size, you can not store number the elements more than the capacity of the queue.
    The queue also follows FIFO (first-in-first-out) rule for storing and removing elements from the queue.
    If you try to put an element into a full queue or to take an element from an empty queue then the queue will block you.

    The add (E e) method inserts the element passed as a parameter to the method at the tail of this queue.
    If adding the element exceeds the capacity of the queue then the method will throw an IllegalStateException.
    This method returns true if adding of element is successful else it will throw an IllegalStateException.
     */
    static BlockingQueue<Integer> blockingQueu = new ArrayBlockingQueue<>(10);
    
    public static void main(String[] args) throws InterruptedException {

        AtomicInteger i = new AtomicInteger(0);

        Runnable producer = new Runnable() {

            @Override
            public void run() {
                while (true){
                    System.out.println("Producer producing "+i.intValue());
                    try {
                        //blockingQueu.add(i.intValue()); /// throws exception if queue is full
                        blockingQueu.put(i.intValue());
                        Thread.sleep(1000);
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                    i.getAndIncrement();
                }
            }
        };

        new Thread(producer).start();
        //new Thread(producer).start();

        Runnable consumer = new Runnable() {

            @Override
            public void run() {
                while (true){
                    try {
                        System.out.println("Consumer consuming "+blockingQueu.take());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        new Thread(consumer).start();
        //new Thread(producer).start();

        Thread.sleep(1000);
    }
}
