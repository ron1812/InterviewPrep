package com.practice.designpatterns.structural.adapter;

public class School {

    //To write assignment work we would require a pen
    //Pen is an interface with abstract method as write
    //If we dont hve any implementation of Pen and Borrow PilotPen from our friend
    //We would require an adapter class to use pilot pen for assignment work
    /*
    The Adapter pattern should be used when:
    • There is an existing class, and its interface does not match the one you need.
    • You want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that don’t necessarily
      have compatible interfaces.
    • There are several existing subclasses to be use, but it’s impractical to adapt their interface by subclassing every one. An object
      adapter can adapt the interface of its parent class.
     */
    public static void main(String[] args) {

//        Since we dont have implementation of Pen we get null pointer in assignment work
//        AssignmentWork assignmentWork = new AssignmentWork();
//        assignmentWork.writeAssignment();

        //Since Pilot pen is not our class and we can not change it
        //Since PenAdapter is our method we can implement Pen interface and inject pilotpen in it
        AssignmentWork assignmentWork = new AssignmentWork();

        PenAdapter penAdapter = new PenAdapter();
        assignmentWork.setPen(penAdapter);

        assignmentWork.writeAssignment();
    }
}
