package com.practice.solid;

import java.util.List;

public class AreaCalculator implements IAreaCalculator{

    /*
         This method breaks the open closed principle
         Imagine if more Shapes are introduced in the future
         In this case you will have to write another if method
         This means you are modifying the code which goes against O/C principal which defines that
         a class should be open to extension and closed to modification

         Solution: Create an interface Shape and abstract method area and implement sum of areas method as shown
         below in method sumOfAreasV2
     */
      public int sumOfAreas(List<Object> shapes){
           int sum = 0;
           for(int i=0; i < shapes.size();i++){
               Object shape = shapes.get(i);
               if(shape instanceof Square){
                    sum+=Math.pow(((Square)shape).getLength(),2);
               }
               if(shape instanceof Circle){
                   sum+= Math.PI * Math.pow(((Circle)shape).getRadius(),2);
               }
           }
           return sum;
      }

    @Override
    public int sumOfAreasV2(List<Shape> shapes){
        int sum = 0;
        for(int i=0; i < shapes.size();i++){
            Shape shape = shapes.get(i);
            sum+= shape.area();
        }
        return sum;
    }


      /*
        These 2 methods break the single responsibility principle
        This class should only be calculating sum of area and not print in different format
        Thats the reason why the below 2 methods are shifted into Printer class
       */
      public String getJson(int sum){
          return String.format("{sum =%s}",sum);
      }

      public String getCsv(int sum){
         return String.format("sum,%s",sum);
      }
}
