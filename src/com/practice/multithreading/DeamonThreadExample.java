package com.practice.multithreading;

public class DeamonThreadExample {

    // If we set a thread as deamon thread then the jvm will not wait for that thread to complete execution
    // If the main thread task is complete the program will stop execution irrespective of the deamon thread
    // Note : We can only set a thread as deamon before we call THread.start() method or else we will get IllegalThreadStateException
    // We cannot start the same thread again
    public static void main(String[] args) {

        ThreadClass threadClass = new ThreadClass();
        threadClass.setDaemon(true);
        threadClass.start();

        //IllegalThreadStateException occurs here
        //threadClass.setDaemon(true);

        for(int i=0 ; i < 10; i++) {

            System.out.println("Running loop number "+ i +" for Thread name : "+ThreadClass.currentThread().getName());
        }
    }
}

class ThreadClass extends Thread {

    @Override
    public void run() {

        for(int i = 0; i < 100 ; i++){
            System.out.println("Printing Number "+ i +" for Thread Name "+Thread.currentThread().getName());
        }
    }
}
