package com.practice.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrraysExample {

    //Arrays class is only for primitive array types
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        arrayList.add(23);
        arrayList.add(44);

        //Error in this line
        //Arrays.sort(arrayList);

        int[] binSearchArr = {1,2,3,4,5};
        System.out.println("Integer 4 is at index : "+Arrays.binarySearch(binSearchArr,4));

        int[] sortArr = {23,56,76,34,25};
        System.out.println("\nBefore sorting array");
        Arrays.stream(sortArr).forEach(x -> System.out.print(" "+x));
        Arrays.sort(sortArr);
        System.out.println("\nAfter sorting array");
        Arrays.stream(sortArr).forEach(x -> System.out.print(" "+x));

        Arrays.fill(sortArr,2);
        System.out.println("\n\nAfter filling array by 2");
        Arrays.stream(sortArr).forEach(x -> System.out.print(" "+x));
    }
}
