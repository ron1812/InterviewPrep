package com.practice.designpatterns.structural.adapter;

public class AssignmentWork {

    private Pen pen;

    public void setPen(Pen pen) {
        this.pen = pen;
    }

    public void writeAssignment() {
        pen.write("Writing assignment");
    }
}
