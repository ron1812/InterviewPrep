package com.practice.problems;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrintUniqueCharInName {

    //Find unique character using java 8 streams
    public static void main(String[] args) {
        List<String> namesList = Arrays.asList("Geeks for Geeks", "Hello Geeks");

        namesList.stream().map(x -> {
            char[] nameChars = x.toCharArray();

            //Char Stream is not possible hence we have to use intstream and then mapToObj
            Map<Character, Long> charToLongMap = IntStream.range(0, nameChars.length).mapToObj(i -> nameChars[i]).filter(i -> !i.equals(' ')).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

            String uniqueChar = charToLongMap.entrySet().stream().filter(o -> o.getValue() == 1).map(c -> c.getKey().toString()).collect(Collectors.joining(","));

            return uniqueChar;
        }).forEach(System.out::println);


    }
}
