package com.practice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestCommonPrefix {

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefix(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefix(new String[]{"dog","cat"}));
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));

        System.out.println("\nAPPROACH 2\n");

        System.out.println(longestCommonPrefixV2(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefixV2(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefixV2(new String[]{"dog","cat"}));
        System.out.println(longestCommonPrefixV2(new String[]{"ab","a"}));

        System.out.println("\nAPPROACH 3\n");

        System.out.println(longestCommonPrefixV3(new String[]{"flower","flow","flight"}));
        System.out.println(longestCommonPrefixV3(new String[]{"cir","car"}));
        System.out.println(longestCommonPrefixV3(new String[]{"dog","cat"}));
        System.out.println(longestCommonPrefixV3(new String[]{"ab","a"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length == 1){
            return strs[0];
        }

        int minLength = strs[0].length();
        StringBuilder strBuild = new StringBuilder(strs[0]);
        List<Integer> idxList = new ArrayList<>();
        idxList.add(0);

        for(int i=1;i<strs.length;i++){
            if(i <= strs.length-1){

                idxList.add(strBuild.length());
            }
            minLength = Math.min(minLength,strs[i].length());
            strBuild.append(strs[i]);
        }

        int countOfPrefix = 0;
        outer : for(int i=0;i<minLength;i++){

            int count = 1;
            char characterToCheck = strs[0].charAt(i);

            for(int j = 1 ;j<idxList.size(); j++){
                Integer charactIdx = idxList.get(j);
                if(characterToCheck == strBuild.toString().charAt(charactIdx+i)){
                    if(count == idxList.size()-1){
                        countOfPrefix++;
                    }
                    count++;
                }else{
                    break outer;
                }
            }
        }

        if(countOfPrefix == 0){
            return "";
        }

        return strBuild.substring(0,countOfPrefix);
    }

    public static String longestCommonPrefixV2(String[] strs) {

        Arrays.sort(strs);

        char[] firstString = strs[0].toCharArray();
        char[] lastString = strs[strs.length-1].toCharArray();

        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < firstString.length; i++){
            if(firstString[i] != lastString[i]){
                return strs[0].substring(0,i);
            }else{
                stringBuilder.append(strs[0].charAt(i));
            }
        }
        return stringBuilder.toString();
    }

    public static String longestCommonPrefixV3(String[] strs) {

        String firstPrefix = strs[0];
        for(int i=1;i < strs.length;i++){

            while(strs[i].indexOf(firstPrefix) != 0){
                firstPrefix = firstPrefix.substring(0,firstPrefix.length()-1);
                if(firstPrefix.isEmpty()) return "";
            }
        }
        return firstPrefix;
    }
}
