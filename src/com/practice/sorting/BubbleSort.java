package com.practice.sorting;

import java.util.Arrays;

public class BubbleSort {


    //In bubble sort the highest number is shifted to the end after each iteration
    //     10 30 40 1 -3
    // i   0  1  2  3  4
    // index 0 and 1 is compared if index 0 value is greater then swap operation is performed(in this case no swap needed)
    // next index 1 and 2 is checked
    // during index 2 and 3 check index 2 value i.e 40 is greater than index 3 so swap is done
    //     10 20 1 40 -3
    //     10 20 1 -3 40
    // at the end of 1st iteration biggest number is shifted to the end
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int[] arr = {10, 30, 40, 1, -3};

        int count = 0;
        while(count < arr.length){
            int i=0;
            int j=1;

            while(j <  arr.length){
                if(arr[i] > arr[j]){
                    swap(arr,i,j);
                }
                i++;
                j++;
            }
            count++;
        }

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("\n"+(System.currentTimeMillis() - start));
    }

    private static void swap(int[] arr,int i,int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}
