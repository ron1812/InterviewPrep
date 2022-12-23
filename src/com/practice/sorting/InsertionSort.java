package com.practice.sorting;

import java.util.Arrays;

public class InsertionSort {

    //In this sorting technique we have 2 parts
    // Sorted and unsorted part

    //     10 30 40 1 -3
    // i   0  1  2  3  4
    // for first iteration assume 0th index to be sorted part
    // and 1st index to the end as unsorted part
    // assume 30 as currentunsorted index . but 30 is greater than 10 so no sorting is required
    // for 2nd iteration same goes for 40 . 40 is greater than 10 and 30 so no swap required
    // for 3rd iteration 40,30 and 10 would shift one position towards right to make space for 1 to shift to index 0
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int[] arr = {10, 30, 40, 1, -3};

        for(int i=1;i<arr.length;i++){
            int unsortedCurr = arr[i];
            int j = i-1;
            while(j >= 0 && unsortedCurr < arr[j]){
                arr[j+1] = arr [j];
                j--;
            }

            arr[j+1] = unsortedCurr;
        }

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("\n"+(System.currentTimeMillis() - start));
    }
}
