package com.practice.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class SetExample {

    public static void main(String[] args) {
        Set<Integer> setTest = new HashSet<>();
        setTest.add(12);
        setTest.add(12);
        setTest.add(23);
        setTest.add(55);

        System.out.println(setTest.size());

        System.out.println(setTest.contains(22));

        setTest.iterator().forEachRemaining(x -> System.out.print(" "+x));

        // ****************** LINKED HASH SET **************************

        System.out.print("\n****************** LINKED HASH SET **************************");

        Set<Integer> setTestLinked = new LinkedHashSet<>();
        setTestLinked.add(12);
        setTestLinked.add(12);
        setTestLinked.add(23);
        setTestLinked.add(55);

        System.out.println(setTestLinked.size());

        System.out.println(setTestLinked.contains(23));

        setTestLinked.iterator().forEachRemaining(x -> System.out.print(" "+x));
    }
}
