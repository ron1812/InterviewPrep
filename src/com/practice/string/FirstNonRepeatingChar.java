package com.practice.string;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String word = "GeeksQuiz";

        HashMap<Character,Integer> char2CountMap = new LinkedHashMap<>();
        for(int i=0;i<word.length();i++){
            Character c = word.charAt(i);
            if(char2CountMap.containsKey(c)){
                Integer count = char2CountMap.get(c);
                char2CountMap.put(c,count+1);
            }else{
                char2CountMap.put(c,1);
            }
        }

        for (Map.Entry<Character, Integer> next : char2CountMap.entrySet()) {
            if (next.getValue() == 1) {
                System.out.println("First non repeating character is " + next.getKey());
                break;
            }
        }
    }
}
