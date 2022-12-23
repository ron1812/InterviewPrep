package com.practice.java8.interfaceAndAbstract;

/*
1) Fields
Interface fields are public, static and final by default. Interfaces still don’t support non-static and non-final variables. Interfaces can only have public, static and final variables. On the other hand, abstract class can have static as well as non-static and final as well as non-final variables. They also support private and protected variables along with public variables.

2) Methods
After Java 8, an interface can have default and static methods along with abstract methods. Interfaces don’t support final methods. But, abstract classes support final as well as non-final methods and static as well as non-static methods along with abstract methods.

Also note that, only interfaces can have default methods. Abstract classes can’t have default methods.

3) Constructors
Interfaces can’t have constructors. Abstract classes can have any number of constructors.

4) Member’s Accessibility
All members of interfaces are public by default. Interfaces don’t support private and protected members. But, abstract classes support all type of members – private, protected and public members.

5) Multiple Inheritance
A class can extend only one abstract class, but can implement multiple interfaces. Thus, a class can inherit multiple properties from multiple sources only through interfaces, not through abstract classes.
 */

/*

Differences between static and default methods in Java 8:

1) Default methods can be overriden in implementing class, while static cannot.

2) Static method belongs only to Interface class, so you can only invoke static method on Interface class, not on class implementing this Interface, see:

public interface MyInterface {
    default void defaultMethod(){
        System.out.println("Default");
    }

    static void staticMethod(){
        System.out.println("Static");
    }
}

public class MyClass implements MyInterface {

    public static void main(String[] args) {

        MyClass.staticMethod(); //not valid - static method may be invoked on containing interface class only
        MyInterface.staticMethod(); //valid
    }
}
3) Both class and interface can have static methods with same names, and neither overrides other!

public class MyClass implements MyInterface {

    public static void main(String[] args) {

        //both are valid and have different behaviour
        MyClass.staticMethod();
        MyInterface.staticMethod();
    }

    static void staticMethod(){
        System.out.println("another static..");
    }
}


 */
interface anyInterface
{
    int i = 10;            //By default, interface fields are public, static and final
     
    void abstractMethod();          //Interface can have abstract method

    default void defaultMethod()
    {
        System.out.println("Interface can have default method");
    }
     
    static void staticMethod()
    {
        System.out.println("Interface can have static method");
    }
     
    //No constructors in an interface
     
    //No non-static and non-final variables in an interface
     
    //No private fields and methods in an interface
     
    //No protected fields and methods in an interface
     
    //No final methods in an interface
}
 
abstract class anyAbstractClass
{
    private int a;          //Abstract class can have private field
     
    protected int b;        //Abstract class can have protected field
     
    public int c;           //Abstract class can have public field
     
    static int d;           //Abstract class can have static field
     
    final int e = 10;       //Abstract class can have final field
     
    int f;                  //Abstract class can have non-static and non-final field
     
    public anyAbstractClass() 
    {
        System.out.println("Abstract class can have constructors");
    }
      
    abstract void abstractmethod();    //Abstract class can have abstract method
     
    private static void staticMethod() 
    {
        System.out.println("Abstract class can have private and static method");
    }
     
    public void nonStaticMethod()
    {
        System.out.println("Abstract class can have public and non-static method");
    }
     
    protected void protectedMethod() 
    {
        System.out.println("Abstract class can have protected method");
    }
     
    final void finalMethod()
    {
        System.out.println("Abstract class can have final method");
    }
     
    //No default method in an abstract class
}