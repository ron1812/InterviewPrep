package com.practice.multithreading;

import java.util.concurrent.*;

public class CyclicBarrierExample {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(4);

        // Cyclic barrier

//        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
//
//        executorService.execute(new DependentCyclicService(cyclicBarrier));
//        executorService.execute(new DependentCyclicService(cyclicBarrier));
//        executorService.execute(new DependentCyclicService(cyclicBarrier));

        // Cyclic barrier using Phaser

        Phaser phaser = new Phaser(3);

        executorService.execute(new DependentPhaserCyclicService(phaser));
        executorService.execute(new DependentPhaserCyclicService(phaser));
        executorService.execute(new DependentPhaserCyclicService(phaser));

        executorService.shutdown();
    }
}

class DependentCyclicService implements Runnable {

    public CyclicBarrier cyclicBarrier;

    public DependentCyclicService(CyclicBarrier cyclicBarrier){
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println("Running thread "+Thread.currentThread().getId()+" Awaiting for all 3 threads to reach a common point");

        try {
            Thread.sleep(1000);
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Running thread "+Thread.currentThread().getId()+" continuing with its task");

    }
}

class DependentPhaserCyclicService implements Runnable {

    public Phaser phaser;

    public DependentPhaserCyclicService(Phaser phaser){
        this.phaser = phaser;
    }

    @Override
    public void run() {
        System.out.println("Running thread "+Thread.currentThread().getId()+" Awaiting for all 3 threads to reach a common point");

        phaser.arriveAndAwaitAdvance();

        System.out.println("Running thread "+Thread.currentThread().getId()+" continuing with its task");

    }
}
