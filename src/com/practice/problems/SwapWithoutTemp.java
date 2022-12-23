package com.practice.problems;

public class SwapWithoutTemp {

    public static void main(String[] args) {
        int a = 3;
        int b = 2;

        a = a + b ;
        b = a - b ;
        a = a - b ;

        System.out.println("Swapped a = "+a+" b= "+b);
    }
}
