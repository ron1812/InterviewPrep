package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListEquals {

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("A","B","C");
        List<String> l2 = new ArrayList<>(Arrays.asList("A","C","B"));
        List<String> l3 = new ArrayList<>(Arrays.asList("A",new String("B"),"C"));

        // Checks if each and every element in order
        System.out.println(l1.equals(l2));
        System.out.println(l1.equals(l3));

        // Checks if each and every element is present in both list without checking order
        System.out.println(l1.containsAll(l3));
        System.out.println(l1.containsAll(l2));

        // CONTAINS Does not accept a list
        System.out.println(l1.contains(l3));
        System.out.println(l1.contains("A"));
    }
}
