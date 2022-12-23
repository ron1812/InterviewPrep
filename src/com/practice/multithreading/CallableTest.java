package com.practice.multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int countOfCore = Runtime.getRuntime().availableProcessors();

        System.out.println("Cores available are "+countOfCore);

        ExecutorService executorService = Executors.newFixedThreadPool(countOfCore);

        List<Future<Integer>> allFutures = new ArrayList<>();
        for(int i = 0;i < 3;i++){
            allFutures.add(executorService.submit(new CallableClassExample(i)));
        }

        //You can perform any operations here that is unrelated to the future tasks


        //Time to fetch the results of each future
        for(Future<Integer> futureInt : allFutures){

            Integer integerValue = futureInt.get(); //blocking call
            System.out.println("Future value is "+integerValue);
        }

        executorService.shutdown();
    }
}

class CallableClassExample implements Callable<Integer> {

    private final int threadName;

    public CallableClassExample(int threadName){
        this.threadName = threadName;
    }

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Executing Thread name "+threadName);
       return new Random().nextInt();
    }
}
