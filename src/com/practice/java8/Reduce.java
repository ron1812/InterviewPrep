package com.practice.java8;

import java.util.Arrays;
import java.util.OptionalLong;

public class Reduce {

    public static void main(String[] args) {

        OptionalLong reduce = Arrays.stream(new long[]{1, 2, 3, 4, 5}).reduce((long a, long b) -> a * b);

        System.out.println(reduce.getAsLong());

        //we can pass an initial value as well
        long reduce1 = Arrays.stream(new long[]{1, 2, 3, 4, 5}).reduce(Long.valueOf(50),(long a, long b) -> a * b);

        System.out.println(reduce1);
    }
}
