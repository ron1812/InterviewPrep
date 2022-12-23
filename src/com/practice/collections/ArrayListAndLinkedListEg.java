package com.practice.collections;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListAndLinkedListEg {

    //Arraylist increases by 50% of its initial size once its full
    //initial capacity is 10
    /*
    Exception: throws IndexOutOfBoundsException which occurs
    when the index is trying to be accessed which isn’t there in the allocated memory block.
     In java, this exception is thrown when a negative index is accessed or an index of memory space.
     Here particularly when an index greater than the size of ArrayList is trying to be fetched or the insertion of an element
     at an index greater than size() of ArrayList is fetched.
     */
    public static void main(String[] args) {
        List<Integer> intArrList = new ArrayList<>();
        intArrList.add(1);
        intArrList.add(3);

        System.out.println("Printing Array list second element");
        System.out.println(intArrList.get(1));

        System.out.println("Printing ArrayList");
        intArrList.forEach(System.out::println);

        intArrList.set(0,4);
        System.out.println("Printing ArrayList after set operation on index 0 as 4");
        intArrList.forEach(System.out::println);

        intArrList.add(0,10);
        System.out.println("Printing ArrayList after add operation on index 0 as 10");
        intArrList.forEach(System.out::println);

        System.out.println("######################################################################");

        List<Integer> intLinkedArrList = new LinkedList<>();
        intLinkedArrList.add(1);
        intLinkedArrList.add(3);

        System.out.println("Printing Linked list second element");
        System.out.println(intLinkedArrList.get(1));

        System.out.println("Printing Linked List");
        intLinkedArrList.forEach(System.out::println);

        intLinkedArrList.set(0,4);
        System.out.println("Printing Linked List after set operation on index 0 as 4");
        intLinkedArrList.forEach(System.out::println);

        intLinkedArrList.add(0,10);
        System.out.println("Printing Linked List after add operation on index 0 as 10");
        intLinkedArrList.forEach(System.out::println);
    }
}
