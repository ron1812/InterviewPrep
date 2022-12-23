package com.practice.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileAndAtomicInt {

    // Volatile is mostly used for flags
    // each thread stores results of its variable in thread local
    // so in this case if any other thread want to access the variable it might get the wrong flag value
    // This is also called visibility issue
    // hence we use volatile. It pushes the value into the memory and also reads from memory instead of cache
    volatile int i = 0;

    public static void main(String[] args) {

        // If we want to increment an integer (i++) and if multiple thread access and try to increment the same integer variable
        // We cant use volatile here because the issue that arises is increment has 2 operationms
        // first get the value of the variable then add one to it and then write it into memory
        // if during the write operation of thread 1. Thread 2 fetchs the variable value it will get 1 but actually
        // after just sometime the value is updated to 2
        // to overcome this issue we use atomic integer

        AtomicInteger atInt = new AtomicInteger();
        atInt.getAndIncrement();
    }
}
