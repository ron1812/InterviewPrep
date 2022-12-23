package com.practice.java8;

import java.util.stream.IntStream;

public class PrimeNumber {

    public static void main(String[] args) {
        Integer number = 7;

        boolean b = IntStream.range(2, number).noneMatch(x -> number % x == 0);

        System.out.println(b);
    }
}
