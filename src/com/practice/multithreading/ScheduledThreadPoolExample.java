package com.practice.multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPoolExample {

    public static void main(String[] args) {

        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        //Runs the task once after the specified time
        scheduledExecutorService.schedule(new RunnableClassExample(0),10, TimeUnit.SECONDS);

        //Waits for initial time delay of 5secs and then runs the task after every interval of specified time(7sec) irrespective of previous task completion
        scheduledExecutorService.scheduleAtFixedRate(new RunnableClassExample(1),5,7, TimeUnit.SECONDS);

        //Waits for initial time delay of 5secs and then runs the task after every interval of specified time(8sec) only after the previous task is completed
        scheduledExecutorService.scheduleWithFixedDelay(new RunnableClassExample(2),5,8, TimeUnit.SECONDS);

        //scheduledExecutorService.shutdown();
    }
}
