package com.practice.array;

import java.util.Arrays;

public class ProductArrayExceptSelf {

    /*
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

    You must write an algorithm that runs in O(n) time and without using the division operation.


    SUDO

    [1 2 3 4]

    1 2 6 24   == forward product

    24 24 12 4   == reverse product

    if you need element at index 2 i.e value 3
    forward[2-1] * reverse[2+1] = 2 * 4 = 8

    final o/p is 24	12	8 6
     */

    public static int[] productExceptSelf(int[] nums) {
        int start = 0;
        int end = nums.length-1;

        int[] forwardProduct = new int[nums.length];
        int[] reverseProduct = new int[nums.length];

        int forwardProductInt = 1;
        int reverseProductInt = 1;
        while(start < nums.length && end >= 0){
            forwardProductInt *= nums[start];
            forwardProduct[start] = forwardProductInt;
            reverseProductInt *= nums[end];
            reverseProduct[end] = reverseProductInt;
            start++;
            end--;
        }

        int[] outputProduct = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(i == 0){
                outputProduct[i] = reverseProduct[i+1];
            }else if(i == nums.length-1){
                outputProduct[i] = forwardProduct[i-1];
            }else{
                outputProduct[i] = forwardProduct[i-1] * reverseProduct[i+1];
            }
        }

        return outputProduct;
    }

    public static void main(String[] args) {
        Arrays.stream(productExceptSelf(new int[]{1, 2, 3, 4})).forEach(x -> System.out.print(x+"\t"));
    }
}
