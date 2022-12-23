package com.practice.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class OddEvenPrinterUsingCompleteFuture {

    static IntPredicate evenPred = (e) -> e%2 == 0;
    static IntPredicate oddPred = (o) -> o%2 != 0;
    static Object obj = new Object();

    public static void main(String[] args) throws InterruptedException {

        CompletableFuture.runAsync(() -> OddEvenPrinterUsingCompleteFuture.printNumber(evenPred));
        CompletableFuture.runAsync(() -> OddEvenPrinterUsingCompleteFuture.printNumber(oddPred));

        Thread.sleep(1000);
    }

    public static void printNumber(IntPredicate pred){
        IntStream.range(0,10).filter(pred).forEach(OddEvenPrinterUsingCompleteFuture::execute);
    }

    public static void execute(int number){
         synchronized (obj){
             try {
                 System.out.println("Printing number "+number+ " by Thread Number "+Thread.currentThread().getName());
                 obj.notify();
                 obj.wait();
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }
    }
}
