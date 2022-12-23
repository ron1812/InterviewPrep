package com.practice.sorting;

import java.util.Arrays;

public class MergeSort {


    public static void conquer(int[] arr,int si, int mid, int ei){

        int[] merged = new int[ei - si + 1];

        int idx1 = si;
        int idx2 = mid+1;
        int x = 0;

        while (idx1 <= mid && idx2 <= ei){
            if(arr[idx1] <= arr[idx2]){
                merged[x] = arr[idx1];
                x++;
                idx1++;
            }else{
                merged[x] = arr[idx2];
                x++;
                idx2++;
            }
        }

        while (idx1 <= mid){
            merged[x] = arr[idx1];
            idx1++;
        }

        while (idx2 <= ei){
            merged[x] = arr[idx2];
            idx2++;
        }

        for(int i = 0, j = si; i < merged.length ; i++,j++){
            arr[j] = merged[i];
        }
    }

    public static void divide(int[] arr, int si, int ei){
        if(si >= ei){
            return;
        }

        int mid = si + (ei - si)/2;    /// same as si + ei / 2  but this could cause issue if number is huge
        divide(arr,si,mid);
        divide(arr,mid+1,ei);
        conquer(arr,si,mid,ei);
    }

    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        int[] arr = {6, 3, 9, 5, 2, 8};

        divide(arr,0,arr.length-1);

        Arrays.stream(arr).forEach(System.out::println);

        System.out.println("\n"+(System.currentTimeMillis() - start));
    }
}
