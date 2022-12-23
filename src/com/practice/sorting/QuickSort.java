package com.practice.sorting;

import java.util.Arrays;

public class QuickSort {


    /*
    Time Complexity

        Worst : O(n^2)
        Average : O(nlogn)

     Merge sort has a worst case time complexity of O(nlogn) but still java has used quick sort in the Arrays.sort method

     The reason being that memory used in merge sort is very high and the memory in quick sort is less because it
     modifies the same arr by swapping

     Worst case scenario is rarely met in Quick sort algorithm
     */

    /*
     In this algorithm we select a pivot in the array (in this particular implementation we have used the pivot as the last
     element of the array)

     Lets assume the array as
          6 3 9 5 2 8
     idx  0 1 2 3 4 5

      In this case the pivot is idx 5 and element is 8

      One pointer i has to be maintained as low-1
      this pointer is responsible to swap the elements which are less that the pivot element

     loop will iterate from low that is 0 to less than high
     each element is compared with the pivot element
     if the element is smaller than the pivot element then
     1) increase the i pointer (i+1) = 0
     2) swap the element at arr[j] with arr[i]
     3) once the loop is over we need to shift the pivot to it proper location in the array

        6, 3, 5, 2, 8, 9

     i.e the location of pivot element(8) is changed to idx 4

     */

    public static int pivotIdx(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low-1;

        for(int j=low; j<high; j++) {
            if(arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Pivot element has to be shifted to its desired position in the array
        i++;
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;

        return i;
    }

    public static void quickSort(int[] arr,int low,int high){
        if(low < high){
            int pivotIdx = pivotIdx(arr,low,high);

            quickSort(arr,low,pivotIdx-1);
            quickSort(arr,pivotIdx+1,high);
        }
    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        int[] intArr = {6, 3, 9, 5, 2, 8};

        quickSort(intArr,0,intArr.length-1);

        Arrays.stream(intArr).forEach(x -> System.out.print(" "+x));

        System.out.println("\n"+(System.currentTimeMillis() - start));
    }
}
