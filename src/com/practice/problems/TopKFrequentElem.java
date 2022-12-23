package com.practice.problems;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentElem {

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,2,2,3,3,3,3};
        //int[] nums = {1,2};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));

        //NOTE: THE BELOW CODE DOESNT WORK. TREEMAP AND TREE SET DOESNT USE HASHCODE AND EQUALS METHOD
//        TreeMap<CustomClass,CustomClass> treeMap = new TreeMap<>(Comparator.comparingInt(x -> x.frequency));
//
//        for(int num : nums){
//
//            CustomClass customClass = new CustomClass(num);
//            if(treeMap.containsKey(customClass)){
//
//                CustomClass existingCustClass = treeMap.get(customClass);
//                existingCustClass.frequency += 1;
//            }else{
//                customClass.frequency = 1;
//                treeMap.put(customClass,customClass);
//            }
//        }
//
//        System.out.println(treeMap.keySet().stream().limit(2).map(x -> x.value).collect(Collectors.toList()));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> hashMap = new HashMap<>();

        for(int num : nums){

            hashMap.put(num,hashMap.getOrDefault(num,0)+1);
        }


        Comparator<Integer> customComparator = new Comparator<Integer>() {

            @Override
            public int compare(Integer s1, Integer s2) {
                Integer freq1 = hashMap.get(s1);
                Integer freq2 = hashMap.get(s2);

                return freq2.compareTo(freq1);
            }
        };

        PriorityQueue<Integer> priorQ = new PriorityQueue<>(customComparator);

        hashMap.keySet().stream().forEach(x -> priorQ.offer(x));

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = priorQ.poll();
        }

        return result;
    }
}

class CustomClass {

    public Integer value;
    public Integer frequency;

    public CustomClass(int value) {
        this.value = value;
        this.frequency = 0;
    }

    @Override
    public boolean equals(Object o) {
        return this.value.equals(((CustomClass)o).value);
    }

    @Override
    public int hashCode() {
        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return "CustomClass{" +
                "value=" + value +
                ", frequency=" + frequency +
                '}';
    }
}