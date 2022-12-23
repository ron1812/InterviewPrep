package com.practice.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {

    public static void main(String[] args) {

        //int[] arr = {1,2,3,4,5,6,7,0};
        int[] arr = {4,7,3,2,5};

        Scanner d = new Scanner(System.in);
        System.out.println("Do you want to rotate to left or right");
        String rotateType = d.next();

        if("left".equalsIgnoreCase(rotateType) || "l".equalsIgnoreCase(rotateType)){
            System.out.println("Rotation left factor");
            Integer rotationInt = d.nextInt();

            int arrLength = arr.length;
            rotationInt = rotationInt % arr.length;

            //3 2 5 4 7  - o/p

            reverseArr(arr,0,arrLength-1);                      //5 2 3 7 4
            reverseArr(arr,0,arrLength-1-rotationInt);          //3 2 5 7 4
            reverseArr(arr,arrLength-rotationInt,arrLength-1);  //3 2 5 4 7
        }else{
            System.out.println("Rotation right factor");
            Integer rotationInt = d.nextInt();

            int arrLength = arr.length;
            rotationInt = rotationInt % arr.length;

            //2 5 4 7 3 - o/p

            reverseArr(arr,0,arrLength-1);      //5 2 3 7 4
            reverseArr(arr,0,rotationInt-1);    //2 5 3 7 4
            reverseArr(arr,rotationInt,arrLength-1); //2 5 4 7 3
        }
        Arrays.stream(arr).forEach(x -> System.out.print(x+"\t"));
    }

    private static void reverseArr(int[] arr, int start, int end) {
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
