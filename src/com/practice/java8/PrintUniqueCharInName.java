package com.practice.java8;

import java.util.*;
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


        // ***********************  PRINT INDEX of first unique character ************************************************

        String s = "loveleetcode";

        LinkedHashMap<Character, Long> mapOfCharToInt = s.chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));

        Optional<Map.Entry<Character, Long>> first = mapOfCharToInt.entrySet().stream().filter(o -> o.getValue() == 1).findFirst();
        if(first.isPresent()){

            Map.Entry<Character, Long> characterLongEntry = first.get();
            Character c = characterLongEntry.getKey();

            System.out.println(s.indexOf(c));
        }else{
            System.out.println(-1);
        }
    }
}
