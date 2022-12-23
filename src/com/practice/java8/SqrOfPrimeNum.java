package com.practice.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SqrOfPrimeNum {

    public static void main(String[] args) {

        List<Double> collect = Stream.iterate(1, i -> i + 1)
                .filter(SqrOfPrimeNum::isPrime).peek(System.out::println)
                .map(x -> Math.sqrt(x))
                .limit(10).collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    private static boolean isPrime(int num) {
        return num>1 && IntStream.range(2,num).noneMatch(x -> num % x == 0);
    }
}
