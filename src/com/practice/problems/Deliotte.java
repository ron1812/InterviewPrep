package com.practice.problems;

import java.util.Arrays;

public class Deliotte {

    public static void main(String[] args) {

        //int[] numbers = {4,3,5,1,4,4,7};
        //int[] numbers = {12,12,12,15,10};
        int[] numbers = {18,26,18,24,24,20,22};

        //18,18,20,22,24,24,26
        //1,3,4,4,4,5,7
        Arrays.sort(numbers);

        int maxCount = 0;

        for (int i=0; i<numbers.length; i++){
            int start = i;
            int end = i+1;
            int diff = 0;
            int counter = 0;
            while(end != start && end < numbers.length){

                if(start == i){

                    diff = numbers[end] - numbers[start];
                    counter = 2;
                    start++;
                    end++;
                }else{

                    if(numbers[end] - numbers[start] == diff){
                        counter++;
                        start++;
                        end++;
                    }else if(numbers[end] - numbers[start] < diff){
                        if(end < numbers.length-1){
                            end++;
                        }
                    }else{
                        start++;
                        if(end < numbers.length-1){
                            end++;
                        }

                    }

                }
            }

            maxCount = Math.max(counter,maxCount);
        }

        System.out.println(maxCount);
    }
}
