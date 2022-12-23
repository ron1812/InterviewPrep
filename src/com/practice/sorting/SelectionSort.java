package com.practice.sorting;

import java.util.Arrays;

public class SelectionSort {

    // In this sorting we iterate the array and find the minimum element
    // Once the minimum element is found we just place it on the 0th index
    // for second iteration we find the minimum element excluding 0th index and place it in 1st index
    // the same should be done throughout
    //     10 30 40 1 -3
    // i   0  1  2  3  4
    // after first iteration
    //     -3 30 40 1  10
    // after second iteration
    //     -3 1  40 30 10
    public static void main(String[] args) {
        int[] arr = {10, 30, 40, 1, -3};

        for(int i=0;i<arr.length;i++){
            int min = arr[i];
            int minIdx = i;
            int j = i;
            while(j < arr.length){
                if(arr[j] < min){
                    min = arr[j];
                    minIdx = j;
                }
                j++;
            }
            swap(arr,i,minIdx);
        }

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void swap(int[] arr, int i, int minIdx) {
        int temp = arr[minIdx];
        arr[minIdx] = arr[i];
        arr[i] = temp;
    }
}
