package com.practice.multithreading;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Phaser;

public class CountDownLatchExample {


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Count Down Latch

        CountDownLatch countDownLatch = new CountDownLatch(3);

        executorService.execute(new DependentLatchService(countDownLatch));
        executorService.execute(new DependentLatchService(countDownLatch));
        executorService.execute(new DependentLatchService(countDownLatch));

        // Count down latch using Phaser

//        Phaser phaser = new Phaser(3);
//
//        executorService.execute(new DependentPhaserCountDownService(phaser));
//        executorService.execute(new DependentPhaserCountDownService(phaser));
//        executorService.execute(new DependentPhaserCountDownService(phaser));

        System.out.println("Awaiting completion of task");

        countDownLatch.await();
        //phaser.awaitAdvance(3);

        System.out.println("All task done");

        executorService.shutdown();
    }
}

class DependentLatchService implements Runnable {

    public CountDownLatch countDownLatch;

    public DependentLatchService(CountDownLatch c){
        this.countDownLatch = c;
    }

    @Override
    public void run() {
        System.out.println("Running thread "+Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        countDownLatch.countDown();
    }
}

class DependentPhaserCountDownService implements Runnable {

    public Phaser phaser;

    public DependentPhaserCountDownService(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("Running thread "+Thread.currentThread().getId());

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        phaser.arrive();
    }
}
