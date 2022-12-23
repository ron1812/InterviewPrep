package com.practice.array;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BinarySearch {

    public static void main(String[] args) {
        List<Integer> binarySearchList = Arrays.asList(1,6,10,14,22,30,53);

        Scanner in = new Scanner(System.in);
        System.out.println("PLease input the integer to be searched");
        Integer searchTerm = in.nextInt();

        Integer msxIndex = binarySearchList.size() - 1;

        Integer searchIndex = binarySearchInteger(binarySearchList, 0, msxIndex, searchTerm);

        if(searchIndex == -1){
            System.out.println("Search term could not be found");
        }else {
            System.out.println("Search term is at index "+searchIndex);
        }

    }

    public static Integer binarySearchInteger(List<Integer> binarySearchList, Integer lowIndex, Integer maxIndex, Integer searchInt){

        if(maxIndex > lowIndex) {

            Integer midIndex = (lowIndex + maxIndex) / 2 ;

            if(binarySearchList.get(midIndex) > searchInt){
                return binarySearchInteger(binarySearchList,lowIndex,midIndex-1,searchInt);
            }else if(binarySearchList.get(midIndex) < searchInt){
                return binarySearchInteger(binarySearchList,midIndex+1,maxIndex,searchInt);
            }else {
                return midIndex;
            }
        }
        return -1;
    }
}
