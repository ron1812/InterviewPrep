package com.practice.problems;

public class IntegerPalindrome {

    public static void main(String[] args) {
        int checkPalindrome = 121;

        System.out.println(checkPalindrome(checkPalindrome));
        System.out.println(checkPalindromeApp2(checkPalindrome));
    }

    public static boolean checkPalindrome(int checkPalindrome){
        int x = checkPalindrome;
        int total = 0;
        while(x > 0){
            int b = x % 10;
            total = total * 10 + b;
            x = x / 10;
        }

        if(total == checkPalindrome){
            return true;
        }else{
            return false;
        }
    }

    public static boolean checkPalindromeApp2(int checkPalindrome){
        String checkPalindromeStr = String.valueOf(checkPalindrome);
        int start = 0;
        int end = checkPalindromeStr.length()-1;

        if(end > start){
            if(checkPalindromeStr.charAt(start) != checkPalindromeStr.charAt(end)){
                return false;
            }
            start++;
            end--;
        }

        return true;
    }
}
