package com.practice.multithreading;

public class JoinExample {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to ISRO Launch");

        Runnable rocketLaunch = () -> {
           for(int i = 10 ;i > 0; i--){
               System.out.println("Rocket launches in "+i);
               try {
                   Thread.sleep(300);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        };

        Thread thread = new Thread(rocketLaunch);

        thread.start();

        // If join is not used here the sout at the bottom will be printed before countdown
        thread.join();

        //This waits for thread for 500ms and then continues
        //thread.join(2000);

        System.out.println("!!!!!!!!!!!!!!!!!! Rocket Launched !!!!!!!!!!!!!!!!!!!!");
    }
}
