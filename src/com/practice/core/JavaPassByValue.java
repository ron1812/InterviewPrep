package com.practice.core;

public class JavaPassByValue {

    //JAVA is PASS BY VALUE but in case of send object you are sending the address of the
    // object so it changes the variables directly
    public static void main(String[] args) {
        int amt = 9;

        changePrimitive(amt);
        System.out.println("The amount value is "+amt);

        Integer amountWrapper = 20;

        changeWrapperPrimitive(amountWrapper);
        System.out.println("The amount value is "+amountWrapper);

        TestPassByValue testPassByValue = new TestPassByValue();
        testPassByValue.amt = 15;

        changeReference(testPassByValue);
        System.out.println("The amount value is "+testPassByValue.amt);
    }

    public static void changePrimitive(int amt){
        amt = 10;
    }

    public static void changeWrapperPrimitive(Integer amt){
        amt = 10;
    }

    public static void changeReference(TestPassByValue testPassByValue){
        testPassByValue.amt = 10;
    }
}

class TestPassByValue {
    public int amt;
}