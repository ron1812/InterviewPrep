package com.practice.string;

import java.util.*;
import java.util.stream.Collectors;

public class GroupAnagram {

    /*
    Given an array of strings strs, group the anagrams together. You can return the answer in any order.
    An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

    Input: strs = ["eat","tea","tan","ate","nat","bat"]
    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    Sort each character string in the array and group them
     */

    public static List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> str2index = new HashMap();

        for(int i=0; i< strs.length; i++){

            char tempArray[] = strs[i].toCharArray();
            Arrays.sort(tempArray);
            String sortedStr = new String(tempArray);

            if(str2index.containsKey(sortedStr)){
                List<String> listOfStr = str2index.get(sortedStr);
                listOfStr.add(strs[i]);
            }else{
                List<String> listOfStr = new ArrayList();
                listOfStr.add(strs[i]);
                str2index.put(sortedStr,listOfStr);
            }
        }

        return str2index.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());

    }

    public static void main(String[] args) {
        System.out.println(groupAnagrams((String[]) Arrays.asList("eat","tea","tan","ate","nat","bat").toArray()));
    }
}
