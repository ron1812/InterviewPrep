package com.practice.array;

import java.util.ArrayList;
import java.util.List;

public class Reverse {

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(1);
        a.add(4);
        a.add(3);
        a.add(2);

        int start = 0;
        int end = a.size()-1;

        while(start < end){
            Integer startVal = a.get(start);
            Integer endVal =a.get(end);
            a.set(start, endVal);
            a.set(end, startVal);
            start ++;
            end --;
        }

        a.forEach(System.out::println);
    }
}
