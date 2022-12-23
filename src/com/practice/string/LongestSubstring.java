package com.practice.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int slowCounter = 0;
        int fastCounter = 0;
        Set<Character> charSet = new HashSet();

        while(fastCounter < s.length()){
            if(charSet.contains(s.charAt(fastCounter))){
                charSet.remove(s.charAt(slowCounter));
                slowCounter++;
            }else{
                charSet.add(s.charAt(fastCounter));
                fastCounter++;
                max = Math.max(max,fastCounter-slowCounter);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Longest substring is "+lengthOfLongestSubstring("abba"));
    }
}
