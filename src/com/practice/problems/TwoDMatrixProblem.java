package com.practice.problems;

public class TwoDMatrixProblem {

    /*
        In this problem elements across the row and column are sorted
        We need to return true/false if we are able to find the passed number

        Brute Force
        scan each row in the matrix and find the element
        time complexity (m x n)(column x row) worst case scenario

        Binary search on each row
        Since each row is sorted we can do a binary search on each row.
        time complexity n (traverse each row) x log n (binary search time)

        Optimised approach
        take last element (column) of first row and compare with the element to search
        if the element is greater then move downwards
        if the element is smaller then move towards the left

          time complexity n (traverse each row length) plus m (traverse each column length)
     */

    public static void main(String[] args) {
        int[][] twoDMat = {{1,2,3,4},
                          {5,7,9,13},
                          {8,10,11,15}};

        System.out.println(findElement(twoDMat,7));
    }

    private static boolean findElement(int[][] twoDMat, int numToFind) {
        int rowLen = twoDMat.length;
        int colLen = twoDMat[0].length;
        int movingElem;

        int row = 0;
        int col = colLen-1;
        while(row < rowLen && col < colLen){
            movingElem = twoDMat[row][col];
            if(numToFind > movingElem){
                row++;
            } else if (numToFind < movingElem) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }
}
