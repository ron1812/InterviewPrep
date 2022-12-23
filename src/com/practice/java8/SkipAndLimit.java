package com.practice.java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SkipAndLimit {

    // Find 2nd and 3rd highest number
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(10, 4, 2, 6, 5, 8);
        list.stream().sorted(Comparator.reverseOrder()).skip(1).limit(2).forEach(System.out::println);

    }
}
