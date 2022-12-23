package com.practice.java8;

import java.util.*;

public class FindMinMaxCountSum {

    public static void main(String[] args) {
        List<Integer> listOfInt = new ArrayList<>(5);
        listOfInt.add(2);
        listOfInt.add(5);
        listOfInt.add(10);
        listOfInt.add(null);

        listOfInt.removeIf(Objects::isNull);

        int maxINt = listOfInt.stream().mapToInt(i -> i).max().getAsInt();
        System.out.println("Max "+maxINt);

        int maxInt2 = listOfInt.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
        System.out.println("Max2 "+maxInt2);

        int minINt = listOfInt.stream().mapToInt(i -> i).min().getAsInt();
        System.out.println("Min "+minINt);

        int sum = listOfInt.stream().mapToInt(i -> i).sum();
        System.out.println("Sum "+sum);

        int reduceSum = listOfInt.stream().mapToInt(i -> i).reduce((a,b) -> a+b).getAsInt();
        System.out.println("Reduce Sum "+reduceSum);

        IntSummaryStatistics stats = listOfInt.stream().mapToInt(i -> i).summaryStatistics();
        System.out.println("Max "+stats.getMax());
        System.out.println("Min "+stats.getMin());
        System.out.println("average "+stats.getAverage());
        System.out.println("sum "+stats.getSum());
        System.out.println("count "+stats.getCount());

        System.out.println("Count "+listOfInt.stream().count());

        listOfInt.stream().sorted().forEach(x -> System.out.print(" "+x));

        System.out.println();

        listOfInt.stream().sorted(Comparator.reverseOrder()).forEach(x -> System.out.print(" "+x));

    }
}
