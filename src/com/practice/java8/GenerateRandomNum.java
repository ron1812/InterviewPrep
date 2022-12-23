package com.practice.java8;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class GenerateRandomNum {

    public static void main(String[] args)
    {

        // using IntStream.generate() method
        // to generate 7 random Integer values
        IntStream stream = IntStream.generate(() ->  (int)(Math.random() * 10000));

        // Displaying the randomly generated values
        stream.limit(7).forEach(System.out::println);

        // using IntStream.generate() method
        // to generate 7 random Integer values
        DoubleStream streamDouble = DoubleStream.generate(() -> Math.random());

        // Displaying the randomly generated values
        streamDouble.limit(7).forEach(System.out::println);
    }
}
