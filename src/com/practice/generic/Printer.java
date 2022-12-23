package com.practice.generic;

public class Printer <T>{

    T printThisThing;

    public Printer(T printThisThing){
        this.printThisThing = printThisThing;
    }
    public void printThisThing(){
        System.out.println(printThisThing);
    }
}

class GenericTest{

    public static void main(String[] args) {
        Printer<Integer> printerInt = new Printer<>(3);
        printerInt.printThisThing();

        Printer<String> printerStr = new Printer<>("Three");
        printerStr.printThisThing();
    }
}
