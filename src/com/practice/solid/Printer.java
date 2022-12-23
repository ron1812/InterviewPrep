package com.practice.solid;

import java.util.List;

public class Printer {

    public String getJson(int sum){
        return String.format("{sum =%s}",sum);
    }

    public String getCsv(int sum){
        return String.format("sum,%s",sum);
    }


    ///DEPENDENCY INVERSION BREAKING

    // Here we are dependent on concrete class which is a bad practice

    AreaCalculator areaCalculator = new AreaCalculator();

    public String getJson(List<Shape> shape){
        return String.format("{sum =%s}",areaCalculator.sumOfAreasV2(shape));
    }

    public String getCsv(List<Shape> shape){
        return String.format("sum,%s",areaCalculator.sumOfAreasV2(shape));
    }

    // This is solution of DEPENDENCY INVERSION where we are dependent on interface rather than concrete class
    //In futre if we have subtractAreaCalculator we can easily pass to this method instead of changing code

    private final IAreaCalculator iAreaCalculator;
    public Printer(IAreaCalculator iAreaCalculator){
        this.iAreaCalculator = iAreaCalculator;
    }

    public String getJsonV2(List<Shape> shape){
        return String.format("{sum =%s}",iAreaCalculator.sumOfAreasV2(shape));
    }

    public String getCsvV2(List<Shape> shape){
        return String.format("sum,%s",iAreaCalculator.sumOfAreasV2(shape));
    }
}
