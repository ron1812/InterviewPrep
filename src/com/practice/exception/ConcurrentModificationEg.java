package com.practice.exception;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class ConcurrentModificationEg {

    public static void main(String[] args) {

        //Fail Fast Iterator
        List<String> testList = new ArrayList<>();
        testList.add("Rohan");
        testList.add("Dsouza");

        for (String test: testList){
            System.out.println(test);
            //Fails here with ConcurrentModificationException
            //testList.add("Test");
        }

        System.out.println("################ Trying to remove element using iterator remove #######################");

        //Note we can use iterators remove method as well
        //We cant use this for copyOnWrite ARRAY
        Iterator<String> iterator = testList.iterator();
        while (iterator.hasNext()){
            String next = iterator.next();
            if(next.equalsIgnoreCase("Rohan")){

                System.out.println("Trying iterator remove "+next);
                iterator.remove();
            }
        }


        System.out.println("################ Print elements after iterator remove #######################");

        testList.forEach(System.out::println);

        //Fail Safe Iterator
        CopyOnWriteArrayList<String> testList2 = new CopyOnWriteArrayList<>();
        testList2.add("Rohan");
        testList2.add("Dsouza");

        System.out.println("################ Original Copy on write arraylist #######################");

        for (String test: testList2){
            System.out.println(test);
            testList2.add("Test");
        }

        System.out.println("################ Addition of new String in Copy on write arraylist #######################");

        //Iterate to know if addition was successful
        for (String test: testList2){
            System.out.println(test);
        }

        System.out.println("################ Trying to override existing value #######################");

        //This doesnt fail because we are not modifying the structure but only overwriting the value
        List<String> testListOverwrite = new ArrayList<>();
        testListOverwrite.add("Rohan");
        testListOverwrite.add("Dsouza");

        for (String test: testListOverwrite){
            System.out.println(test);
            testListOverwrite.set(0,"Dsouza");
        }

        System.out.println("Printing List "+testListOverwrite);
    }
}
