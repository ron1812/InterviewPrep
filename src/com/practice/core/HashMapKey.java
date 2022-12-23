package com.practice.core;


import java.util.*;

/*
We have a map to store String and Integer key-value pairs as shown below. How to store data case-insensitive?
Map<String,Integer>map=new HashMap<>();
map.put("abc",10000);
map.put("ABC",10000);
Above mentioned map should only store one key-value pair.
 */
public class HashMapKey {

    public static void main(String[] args) {

        System.out.println("abc".hashCode());
        System.out.println("ABC".hashCode());

        Map<StringObj,Integer> hashMap = new HashMap();
        hashMap.put(new StringObj("abc"),10000);
        hashMap.put(new StringObj("ABC"),10000);

        System.out.println(hashMap.size());

        TreeMap<String,Integer> treeMap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        treeMap.put("abc",10000);
        treeMap.put("ABC",10000);

        System.out.println(treeMap.size());
    }
}

class StringObj {

    private String text;

    public StringObj(String text){
        this.text = text;
    }

    public String getText(){
        return text;
    }

    @Override
    public int hashCode() {
        return this.text.toLowerCase().hashCode();
    }

    @Override
    public boolean equals(Object obj) {

        String toLowerCase = ((StringObj)obj).text.toLowerCase();

        return this.text.toLowerCase().equals(toLowerCase);
    }
}
