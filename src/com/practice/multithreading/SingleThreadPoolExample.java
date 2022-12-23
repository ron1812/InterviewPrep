package com.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolExample {

    //USe when you want task to be run sequentially
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for(int i = 0;i < 3;i++){
            executorService.execute(new RunnableClassExample(i));
        }

        executorService.shutdown();
    }
}