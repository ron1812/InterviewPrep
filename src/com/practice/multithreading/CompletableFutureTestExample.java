package com.practice.multithreading;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureTestExample {


    /* Completable future is used in order to solve the problem of Future
     Example we have a system where we have to do the below mentioned tasks in sequence (i.e they are depending on each other)

     getOrder --> enrichOrder --> payment --> dispatch --> sendEmail

     if we use future.get after each operation then it blocks the main thread and it cant proceed to other orders

     hence completable future

     */
    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){

            int finalI = i;
            //If all operations/tasks cannot run in parrallel
            CompletableFuture.supplyAsync(() -> getOrder(finalI))
                    .thenApply(order -> enrichOrder(order,finalI))
                    .thenApply(enrichedOrder -> payment(enrichedOrder,finalI))
                    .thenApply(order -> dispatch(order,finalI))
                    .thenAccept(order -> sendEmail(order,finalI));

            //If all operations/tasks cannot run in parrallel and we pass custom executor
//            CompletableFuture.supplyAsync(() -> getOrder(finalI),executorService)
//                    .thenApply(order -> enrichOrder(order,finalI))
//                    .thenApply(enrichedOrder -> payment(enrichedOrder,finalI))
//                    .thenApply(order -> dispatch(order,finalI))
//                    .thenAccept(order -> sendEmail(order,finalI));

            //If all operations/tasks can run in parrallel use Async
//            CompletableFuture.supplyAsync(() -> getOrder(finalI))
//                    .thenApplyAsync(order -> enrichOrder(order,finalI))
//                    .thenApplyAsync(enrichedOrder -> payment(enrichedOrder,finalI))
//                    .thenApplyAsync(order -> dispatch(order,finalI))
//                    .thenAcceptAsync(order -> sendEmail(order,finalI));
        }
    }

    public static Order getOrder(int i){
        System.out.println("Inside get order with thread "+Thread.currentThread().getName()+" and order count "+i);
       return new Order();
    }

    public static Order enrichOrder(Order order,int i){
        System.out.println("Inside enrich order with thread "+Thread.currentThread().getName()+" and order count "+i);
        return order;
    }

    public static Order payment(Order order,int i){
        System.out.println("Inside payment order with thread "+Thread.currentThread().getName()+" and order count "+i);
        return order;
    }

    public static Order dispatch(Order order,int i){
        System.out.println("Inside dispatch order with thread "+Thread.currentThread().getName()+" and order count "+i);
        return order;
    }

    public static Order sendEmail(Order order,int i){
        System.out.println("Inside send email order with thread "+Thread.currentThread().getName()+" and order count "+i);
        return order;
    }
}

class Order{

}
