package com.practice.array;

public class MaxSubArray {

    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

    A subarray is a contiguous part of an array.

    Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
    Output: 6
    Explanation: [4,-1,2,1] has the largest sum = 6.


    Kadane's Algorithm

    compare max sum of previous element to current element

    eg [-2 1 -3]

    [-2 + 1] = -1
    [1] = 1
    max = 1
    maxBetween index is  1 so keep 1 as currentmax and compare with next

    [1 + -3] = -2
    [-3] = -3
     keep -2 as current max

     max = 1 > -2

     output = 1
     */

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = nums[0];
        for(int i=1 ; i<nums.length ;i++){
            int newItem = currentSum + nums[i];
            if(newItem > nums[i]){
                currentSum = newItem;
            }else{
                currentSum = nums[i];
            }

            maxSum = Math.max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
