package com.practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {

    /*
    newCachedThreadPool method creates an executor having an expandable thread pool.
    So this thread pool creates new threads if all other threads in the pool are busy

    It also has the ability to kill threads in the pool which are idle for more than 60seconds

     Such an executor is suitable for applications that launch many short-lived tasks.
     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        for(int i = 0;i < 3;i++){
            executorService.execute(new RunnableClassExample(i));
        }

        executorService.shutdown();
    }
}