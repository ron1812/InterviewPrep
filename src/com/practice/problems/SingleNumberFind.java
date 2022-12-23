package com.practice.problems;

import java.util.Arrays;

public class SingleNumberFind {

    /*
    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

    -If we use XOR operator between two same values , it will return zero.
    -If one of the value is zero, and the other is non-zero, it returns the non-zero value.

    XOR
    X^X = 0
    0^X = X

    Consider an array [1,2,1,3,3] -
    -> (1^2^1^3^3) = 2, it doesn't matter what the order is.
     */
    public static int singleNumber(int[] nums) {

        int n = nums.length;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

    public static int singleNumberV2(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        Arrays.sort(nums);

        for(int j=0;j<nums.length;j++){

            if(j % 2 == 0){
                if(nums.length <= j+1 || nums[j] != nums[j+1]){
                    return nums[j];
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(singleNumberV2(new int[]{4,1,2,1,2}));
    }
}
