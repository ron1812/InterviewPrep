package com.practice.java8;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PrintCountOfEachCharInString {

    public static void main(String[] args) {

        /// ******************************************************************8

        String test = "RohanDsouza";

        String[] split = test.split("");
        char[] chars = test.toCharArray();

        //SINCE WE CANNOT CREATE STREAM OF CHAR ARRAY WE NEED TO USE SPLIT TO GET STRING ARRAY
        Map<String, Long> collect = Arrays.stream(split).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        System.out.println(collect);

        //chars returns intstream of integer value of each character
        Map<Character, Long> collect1 = test.chars().mapToObj(x -> (char)x).collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new, Collectors.counting()));

        System.out.println(collect1);

        long count = test.chars()
                .filter(c -> c == 'R')
                .count();

        System.out.println("Count of character R in string is "+count);
    }
}
