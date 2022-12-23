package com.practice.multithreading;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProdConsCustomBlockingQueue {

    static BlockingQueueCustom<Integer> blockingQueu = new BlockingQueueCustom<>(5);

    public static void main(String[] args) throws InterruptedException {

        AtomicInteger i = new AtomicInteger(0);

        Runnable producer = new Runnable() {

            @Override
            public void run() {
                while (i.get() <= 20){
                    System.out.println("Producer producing "+i.intValue());
                    try {
                        blockingQueu.put(i.intValue());
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
                        Thread.sleep(400);
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

class BlockingQueueCustom<E> {

    int maxSize = 5;
    Queue<E> queue;
    ReentrantLock lock = new ReentrantLock(true);
    Condition notEmpty = lock.newCondition();
    Condition notFull = lock.newCondition();

    public BlockingQueueCustom(int size){
        maxSize = size;
        queue = new LinkedList<>();
    }

    public void put(E item){
        lock.lock();
        try {
            while (queue.size() >= maxSize){
                System.out.println("Waiting for queue to have space to push message");
                notFull.await();
            }
            queue.add(item);
            notEmpty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (queue.isEmpty()){
                System.out.println("Waiting for queue to have message");
                notEmpty.await();
            }
            E remove = queue.remove();/// remove method returns error while poll returns null if queue is empty
            notFull.signalAll();
            return remove;
        }finally {
            lock.unlock();
        }
    }
}
