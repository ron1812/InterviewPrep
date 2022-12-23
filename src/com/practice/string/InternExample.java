package com.practice.string;

public class InternExample {

    /*
       It can be used to return string from memory if it is created by a new keyword. It creates an exact copy of the heap string object in the String Constant Pool.
     */
    public static void main(String[] args) {
        String s1 = "Hello";
        s1 += "World";
        String s2 = "Hello";
        s2+="";
        s2 += "World";
        String s3= s1.intern();
        String s4= s2.intern();
        boolean b1 = s3 == s4;
        boolean b2 = s3.equals(s4);
        boolean b3 = s1.intern() == s2.intern();

        boolean b4 = s1.equals(s2);
        System.out.println(b1 +" "+b2);
        System.out.println(b3 +" "+b4);

        String s5 = new String("Hello");
        String s6 = new String("Hello");
        System.out.println(s5==s6);

        String s7 = "Hello";
        System.out.println(s7==s6);

        System.out.println(s5.intern() == s6.intern());

        System.out.println(s7==s6.intern());
    }
}
