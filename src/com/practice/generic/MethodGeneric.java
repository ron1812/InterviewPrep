package com.practice.generic;

import java.util.ArrayList;
import java.util.List;

public class MethodGeneric {

    public static void main(String[] args) {
        List<Integer> printInt = new ArrayList<>();
        printInt.add(3);

        //This throws an error because  List<Object> is not equal to List<Integer> even if Integer is child of Object class
       // printListObject(printInt);

        printList(printInt);

        // error
        //printListBounded(printInt);
    }

    public static void printListObject(List<Object> printList){
        System.out.println(printList);
    }

    //We need to specify <T> before return type in this case
    public static <T> void printList(List<T> printList){
        System.out.println(printList);
    }

    //Bounded Generic
    public static void printListBounded(List<? extends Animal> printList){
        System.out.println(printList);
    }

    //Wildcard Generic
    public static void printListWildcard(List<?> printList){
        System.out.println(printList);
    }
}

class Animal{

}
