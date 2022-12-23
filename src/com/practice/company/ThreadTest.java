package com.practice.company;

public class ThreadTest implements Runnable{


    @Override
    public void run() {

        synchronized (Test1.obj){

            Test1.obj.notify();
        }
    }
}

class Test1 implements Runnable{
    public static Test1 obj;
    private int data;

    public Test1(){
        data = 10;
    }

    public void run(){
        obj = new Test1();

        synchronized (obj){
            try {
                obj.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        obj.data += 20;

        System.out.println(obj.data);
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Test1());
        Thread t2 = new Thread(new ThreadTest());

        t1.start();
        t2.start();

        System.out.printf(" DRM - ");
    }
}
