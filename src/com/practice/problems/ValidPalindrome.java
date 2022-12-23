package com.practice.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ValidPalindrome {

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(isPalindromeV2("A man, a plan, a canal: Pan_ama"));
    }

    //This method somehow is not giving correct answer if _ is present
    public static boolean isPalindrome(String s) {

        String[] stringArrayOld = s.split("\\W+");

        String alphaNumStr = Arrays.stream(stringArrayOld).map(String::toLowerCase).collect(Collectors.joining());

        String[] stringArray = alphaNumStr.split("");

        if(stringArray.length == 0){
            return true;
        }

        int frontPt = 0;
        int endPt = stringArray.length-1;

        while(frontPt < endPt){

            if(! stringArray[frontPt++].equals(stringArray[endPt--])){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(String s) {

        if(s.length() == 0){
            return true;
        }

        int frontPt = 0;
        int endPt = s.length()-1;

        while(frontPt < endPt){

            if(!Character.isLetterOrDigit(s.charAt(frontPt))){
                frontPt++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(endPt))){
                endPt--;
                continue;
            }

            if(Character.toLowerCase(s.charAt(frontPt++)) != Character.toLowerCase(s.charAt(endPt--))){
                return false;
            }
        }
        return true;
    }
}
