package com.practice.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> mapIdx2Num = new HashMap<>();

        int[] output = new int[2];

        for(int i=0 ; i < nums.length; i++){
            if(mapIdx2Num.containsKey(nums[i])){
                output[0] = mapIdx2Num.get(nums[i]);
                output[1] = i;
                return output;
            }

            if(!mapIdx2Num.containsKey(target-nums[i])){
                mapIdx2Num.put(target-nums[i],i);
            }
        }
        return output;
    }

    //Find position of the elements which adds up to target
    public static void main(String[] args) {
        Arrays.stream(twoSum(new int[]{3,2,5,1,3},6)).forEach(System.out::println);
    }
}
