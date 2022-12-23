package com.practice.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ValidAnagram {

    /*
    Given two strings s and t, return true if t is an anagram of s, and false otherwise.

    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Input: s = "anagram", t = "nagaram"
    Output: true


    Soln : create integer array of 26 length signifying 26 letters
    loop through string and intcrement counter for string 1 and decrement counter for string 2

    at the end all the values in aarray should be 0 else not an anagram
     */
    public static boolean isAnagram(String s, String t) {
        int[] charArr = new int[26];

        if(s.length() != t.length()){
            return false;
        }

        for(int i = 0; i<s.length(); i++){
            charArr[s.charAt(i) - 'a'] += 1;
            charArr[t.charAt(i) - 'a'] -= 1;
        }

        for(int charInt : charArr){
            if(charInt != 0){
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isAnagram("aacc","ccaa"));
    }
}
