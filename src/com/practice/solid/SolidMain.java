package com.practice.solid;

import java.util.Arrays;
import java.util.List;

public class SolidMain {
/*
              SOLID PRINCIPLES

     Single Responsibility
        Each class should have only one sole purpose and not be filled with excessive functionality

     Open Closed
        Classes should be open for extension and closed for modification
        In other words you should not have to rewrite an existing class for implementation of new features

     Liskov Substitution
        This means that every subclass or derived class should be substitutable for their base or parent class

     Interface Segregation
        Interface should not force classes to implement methods which they cant dp
        Large interfaces should be divided into smaller ones (Explaination in SHAPE interface)

     Dependency inversion
       Components should depend on abstraction and not concretion
 */
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(5);

        /*
          This will break the Liskov Substitution principle because
          when noShape is accessed in areaCalculator it will throw an error
          which means subclass noshape is not substitutable to parent
         */
        //Shape noShape = new NoShape();
        //List<Shape> shapes = Arrays.asList(circle, square, noShape);

        List<Shape> shapes = Arrays.asList(circle, square);

        AreaCalculator areaCalculator = new AreaCalculator();
        int sum = areaCalculator.sumOfAreasV2(shapes);

        IAreaCalculator iAreaCalculator = new AreaCalculator();
        Printer printer = new Printer(iAreaCalculator);
        System.out.println(printer.getCsv(sum));
    }
}
