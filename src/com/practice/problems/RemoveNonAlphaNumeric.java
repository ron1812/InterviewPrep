package com.practice.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveNonAlphaNumeric {

    public static void main(String[] args) {


        String[] stringArray = "Krishna ^% Kasyap*@#".split("\\W+");

        String collect = Arrays.stream(stringArray).collect(Collectors.joining());
        System.out.println(collect);
    }
}
