package com.practice.solid;

public interface Shape {

    double area();

    //This here breaks interface segregation since not all shapes are 3D and can calculate volume
    //For example Circle is 2D and Shape is 2D whereas Cube is 3D

    //double volume();
}
