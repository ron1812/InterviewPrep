package com.practice.java8;

import java.util.function.*;

public class FunctionalInterfacePractice {

    /*
    * There are 4 types of functional interfaces
    * Predicate  - Takes in input and returns boolean
    * Functional - Takes in input and returns output
    * Consumer - Takes in input and does not return anything
    * BiConsumer - Takes in 2 input parameters and does not return anything
    * Supplier - Only returns output
    * */
    public static void main(String[] args) {

        //Predicate to check if String is empty
        Predicate<String> testPredicate = p -> p.isEmpty();
        System.out.println(testPredicate.test(""));
        System.out.println(testPredicate.test("notEmpty"));

        //Function to double the Integer passed
        Function<Integer,Integer> testFunction = f -> f*f;
        System.out.println(testFunction.apply(5));

        //Consumer to transform the name of Person object
        Person person =  new Person("Rohan");
        System.out.println("Before consumer transformation name "+person.name);
        Consumer<Person> testConsumer = c -> c.name = c.name.concat("_transformed");
        testConsumer.accept(person);
        System.out.println("Before consumer transformation name "+person.name);

        //Supplier to return randome number
        Supplier<Double> testSupplier = () -> Math.random();
        System.out.println(testSupplier.get());

        //IntBinary Operator
        IntBinaryOperator intBinaryOperator = (int a, int b) -> a + b;
        System.out.println(intBinaryOperator.applyAsInt(5,4));

        //Bi Consumer
        BiConsumer<Integer,String> biConsumer = (Integer a, String b) -> System.out.println("we have "+a+" "+b);
//        biConsumer.accept(5,"Apple");

        BiConsumer<Integer,String> biConsumer2 = (Integer a, String b) -> System.out.println("and after eating all "+a+" "+b+" 0 apple remain");
        biConsumer.andThen(biConsumer2).accept(4,"Apples");
    }
}

class Person{

    public String name;

    public Person(String name){
        this.name =  name;
    }
}
