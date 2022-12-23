package com.practice.core;

import java.io.IOException;

public class OverridingOverloadExample extends T{

    public static void callThisYo(String a){
        System.out.println("Child method "+a);
    }

    /*
    If the superclass method does not declare an exception, subclass overridden method cannot declare the checked exception but it can declare unchecked exception.

    If the superclass method declares an exception, subclass overridden method can declare same, subclass exception or no exception but cannot declare parent exception
     */
    //access modifiers cant be weaker .If parent is public you cant specify protected or private here
    //In case of exception you cant have a parent exception in subclass
    //Uncomment the below line to see the error
//    public void callThis(String a) throws Exception{
//    }

    public void tryThis(){

    }

    public static void main(String[] args) {
        T a=new OverridingOverloadExample();
        //Calls parent static method.Hence static cannot be overridden
        a.callThisYo("s");

        OverridingOverloadExample a1=new OverridingOverloadExample();
        //Calls child static method.Hence static cannot be overridden
        a1.callThisYo("s");
    }
}

class T{

    public void callThis(String a) throws IOException {
        System.out.println(a);
    }

    public static void callThisYo(String a){
        System.out.println("In parent static method "+a);
    }

    public void callThis(int a){
        System.out.println(a);
    }

    public void callThis(double a){
        System.out.println("Inside double"+a);
    }

    public void callThis(float a){
        System.out.println("Inside float"+a);
    }

//    public void callThis(char a){
//        System.out.println("Inside char"+a);
//    }

    static int add(int a,int b){return a+b;}
    static long add(int a,double b){return (long) (a+b);}

    static public void main(String[] args) {
        T t=new T();
        //calls int signature
        t.callThis(2);
        //calls double signature
        t.callThis(2.0);
        //calls float signature
        t.callThis(3.0f);
        //calls int signature if char method is commented
        t.callThis('A');

        System.out.println(add(1,2));
        System.out.println(add(1,2d));
    }

}
