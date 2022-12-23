package com.practice.multithreading;

import java.util.concurrent.atomic.AtomicBoolean;

public class ThreeLetterPrinter {

    AtomicBoolean printA = new AtomicBoolean(true);
    AtomicBoolean printB = new AtomicBoolean(false);
    AtomicBoolean printC = new AtomicBoolean(false);

    public void printA() throws InterruptedException {
        synchronized (this){
            System.out.println("PRINT A INSIDE SYNC BLOCK");
            Thread.sleep(3000);
            while(!printA.get()){
                try {
                    //System.out.println("PRINT A WAITING FOR LOCK");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("PRINT A");
            printA.set(false);
            printB.set(true);
            printC.set(false);
            notifyAll();
        }
    }

    public void printB() throws InterruptedException {
        synchronized (this){
            System.out.println("PRINT B INSIDE SYNC BLOCK");
            Thread.sleep(3000);
            while(!printB.get()){
                try {
                    //System.out.println("PRINT B WAITING FOR LOCK");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("PRINT B");
            printA.set(false);
            printB.set(false);
            printC.set(true);
            notifyAll();
        }
    }

    public void printC() throws InterruptedException {
        synchronized (this){
            System.out.println("PRINT C INSIDE SYNC BLOCK");
            Thread.sleep(3000);
            while(!printC.get()){
                try {
                    //System.out.println("PRINT C WAITING FOR LOCK");
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("PRINT C");
            printA.set(true);
            printB.set(false);
            printC.set(false);
            Thread.sleep(1000);
            notifyAll();
        }
    }

    public static void main(String[] args) {
        ThreeLetterPrinter threeLetterPrinter = new ThreeLetterPrinter();
        PrintA printA = new PrintA(threeLetterPrinter);
        PrintB printB = new PrintB(threeLetterPrinter);
        PrintC printC = new PrintC(threeLetterPrinter);
    }
}

class PrintA implements Runnable {

    ThreeLetterPrinter threeLetterPrinter;

    public PrintA(ThreeLetterPrinter threeLetterPrinter){
        this.threeLetterPrinter = threeLetterPrinter;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
         for(int i =0 ; i<10 ; i++) {
             try {
                 Thread.sleep(3000);
                 threeLetterPrinter.printA();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}

class PrintB implements Runnable {

    ThreeLetterPrinter threeLetterPrinter;

    public PrintB(ThreeLetterPrinter threeLetterPrinter){
        this.threeLetterPrinter = threeLetterPrinter;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for(int i =0 ; i<10 ; i++){
            try {
                Thread.sleep(3000);
                threeLetterPrinter.printB();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class PrintC implements Runnable {

    ThreeLetterPrinter threeLetterPrinter;

    public PrintC(ThreeLetterPrinter threeLetterPrinter){
        this.threeLetterPrinter = threeLetterPrinter;
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for(int i =0 ; i<10 ; i++){
            try {
                Thread.sleep(3000);
                threeLetterPrinter.printC();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
