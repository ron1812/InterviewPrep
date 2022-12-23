package com.practice.multithreading;

// Lets say we need SimpleDateFormatter object in a multi threaded application
// if there are 1000 + thread , 1000 object have to be created which is too much
// Lets say we keep SimpleDateFormatter global, since it is not thread safe we need to local this object
// so the application becomes slow since all threads will wait to acquire this lock
// To overcome this issue we can use Thread Local
// In this lets assume we create a thread pool of 10 threads for 1000 tasks
// each thread will have an object of SimpleDateFormatter created in its thread local
// so for 10 threads 10 simpleDateFormatter is created which is a good approach

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// use case 2 is if we need to paas a user context across various task in a single thread
class ThreadLocalExample {
    //public static ThreadLocal<SimpleDateFormat> threadLocalDateFormatter =  ThreadLocal.withInitial(() -> new SimpleDateFormat("yy-MM-dd"));



}

class BirthdateUser implements Runnable{

    // SimpleDateFormat is not thread-safe, so give one to each thread
    public static final ThreadLocal<SimpleDateFormat> threadLocalDateFormatter = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue()
        {
            return new SimpleDateFormat("yyyy-MM-dd");
        }

        @Override
        public SimpleDateFormat get()
        {
            return super.get();
        }
    };

    private int i;

    public BirthdateUser(int i){
        this.i = i;
    }
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for(int i =0; i< 1000 ;i++){
            executorService.submit(new BirthdateUser(i));
        }

        executorService.shutdown();
    }

    public String getBirthDate(){
        Date birthDate =  new Date();
        final SimpleDateFormat simpleDateFormat = BirthdateUser.threadLocalDateFormatter.get();
        System.out.println("Inside run with thread: "+i+" Thread name is "+Thread.currentThread().getName()
                +" birth date is "+simpleDateFormat.format(birthDate)+ " Simpledate format object hascode is : "+simpleDateFormat.hashCode());
        return simpleDateFormat.format(birthDate);
    }

    @Override
    public void run() {
        getBirthDate();
    }
}
