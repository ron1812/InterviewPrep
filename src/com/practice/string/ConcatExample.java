package com.practice.string;

public class ConcatExample {

    // Concat operator goes from left to right so if we have String first it assumes all to be string and concats
    public static void main(String[] args) {
        System.out.println("Moon" + 10 + 20);
        System.out.println(10 + 20 + "Moon");

        System.out.println("Moon" + (10 + 20));
    }
}
