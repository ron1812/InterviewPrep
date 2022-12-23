package com.practice.multithreading;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class OddAndEvenPrinter {

    private AtomicBoolean isOdd = new AtomicBoolean(true);
    private AtomicInteger counter = new AtomicInteger(1);
    private AtomicInteger maxInt =  new AtomicInteger(10);;

    public void printOdd(){
        while(counter.get() < maxInt.get()){

            synchronized (this){
                while(!isOdd.get()){
                    try {
                        System.out.println("Inside waiting zone of PRINT ODD method");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Odd number from Thread "+Thread.currentThread().getName()+" is "+counter.get());
                counter.getAndIncrement();
                isOdd.set(false);
                notifyAll();
            }
        }
    }

    public void printEven(){
        while(counter.get() <= maxInt.get()){

            synchronized (this){
                while(isOdd.get()){
                    try {
                        System.out.println("Inside waiting zone of PRINT EVEN method");
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Even number from Thread "+Thread.currentThread().getName()+" is "+counter.get());
                counter.getAndIncrement();
                isOdd.set(true);
                notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        OddAndEvenPrinter oddAndEvenPrinter = new OddAndEvenPrinter();
        OddPrinter oddPrinter =  new OddPrinter(oddAndEvenPrinter);
        EvenPrinter evenPrinter = new EvenPrinter(oddAndEvenPrinter);
    }
}

class EvenPrinter implements Runnable{

    OddAndEvenPrinter oddAndEvenPrinter;

    public EvenPrinter(OddAndEvenPrinter oddAndEvenPrinter){
        this.oddAndEvenPrinter = oddAndEvenPrinter;
        Thread t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
        oddAndEvenPrinter.printEven();
    }
}

class OddPrinter implements Runnable{

    OddAndEvenPrinter oddAndEvenPrinter;

    public OddPrinter(OddAndEvenPrinter oddAndEvenPrinter){
        this.oddAndEvenPrinter = oddAndEvenPrinter;
        Thread t1 = new Thread(this);
        t1.start();
    }

    @Override
    public void run() {
            oddAndEvenPrinter.printOdd();
    }
}
