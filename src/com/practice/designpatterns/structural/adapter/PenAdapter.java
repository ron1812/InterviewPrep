package com.practice.designpatterns.structural.adapter;

public class PenAdapter implements Pen {

    PilotPen pen = new PilotPen();

    @Override
    public void write(String text) {
        System.out.println("Reached inside penadapter to write assignment using pilot pen");
        pen.mark(text);
    }
}
