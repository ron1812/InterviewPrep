package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    /*
    Given an integer array nums, return all the triplets
    [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){

            int low = i+1;
            int high = nums.length-1;
            int complement = -nums[i];

            if (i == 0 || (i > 0 && nums[i] != nums[i-1])){

                while (low < high) {

                    if (complement == nums[high] + nums[low]){
                        output.add(Arrays.asList(nums[i],nums[low],nums[high]));
                        while(low < high && nums[low] == nums[low+1]) low++;
                        while(low < high && nums[high] == nums[high-1]) high--;
                        high--;
                        low++;
                    }else if (complement > nums[high] + nums[low]) {
                        low++;
                    }else{
                        high--;
                    }
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-1,0,1,2,-1,-4}).forEach(x -> System.out.print(x+"\t"));
    }
}
