package com.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {

    /*
    If more than specified threads are submitted then tasks are held in a queue until threads become available.

    A new thread is created to take its place if a thread terminates due to failure during execution shutdown on executor is not yet called.

    Any thread exists till the pool is shutdown.
     */
    public static void main(String[] args) {

        int countOfCore = Runtime.getRuntime().availableProcessors();

        System.out.println("Cores available are "+countOfCore);

        ExecutorService executorService = Executors.newFixedThreadPool(countOfCore);

//        for(int i = 0;i < 3;i++){
//            executorService.execute(new RunnableClassExample(i));
//        }
//
//        for(int i = 0;i < 3;i++){
//            executorService.execute(new ThreadExample(i));
//        }

//        new ThreadExample(0).start();
//        new ThreadExample(1).start();
//        new ThreadExample(2).start();

        executorService.shutdown();
    }
}

class RunnableClassExample implements Runnable {

    private final int threadName;

    public RunnableClassExample(int threadName){
        this.threadName = threadName;
    }

    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Inside thread class . Thread name is "+ threadName);
        }
    }
}

class ThreadExample extends Thread {

    private final int threadName;

    public ThreadExample(int threadName){
        this.threadName = threadName;
    }

    public void run() {
        for(int i=0;i<10;i++){
            System.out.println("Inside thread class . Thread name is "+ threadName);
        }
    }
}
