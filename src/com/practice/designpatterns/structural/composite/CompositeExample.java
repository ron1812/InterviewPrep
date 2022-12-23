package com.practice.designpatterns.structural.composite;


// This pattern is used if there is some kind of tree structure
// Composite class can have multiple composite class or leaf under it
// Leaf class is the last class with no other class under it
// Composite and Leaf class both are Components

/*
                              Computer
                                 |
              Cabinet                      Peripherals
                 |                             |
      Hardrive      MotherBoard       Mouse         Keyboard
                         |
                  RAM         CPU

In this tree structure Computer, Peripherals, Motherboard, Cabinet are all COMPOSITE CLASSES
Harddrive, RAM, CPU Mouse and Keyboard are all Leaf Class

 */
public class CompositeExample {

    public static void main(String[] args) {
        Composite computer = new Composite("Computer");
        Composite cabinet = new Composite("Cabinet");
        Composite peri = new Composite("Peripheral");
        Composite motherBoard = new Composite("MotherBoard");

        Leaf harddrive = new Leaf("Harddrive",200);
        Leaf ram = new Leaf("RAM",300);
        Leaf cpu = new Leaf("CPU",5000);
        Leaf mouse = new Leaf("Mouse",600);
        Leaf keyboard = new Leaf("Keyboard",1000);

        computer.addComponent(cabinet);
        computer.addComponent(peri);

        cabinet.addComponent(harddrive);
        cabinet.addComponent(motherBoard);

        motherBoard.addComponent(ram);
        motherBoard.addComponent(cpu);

        peri.addComponent(mouse);
        peri.addComponent(keyboard);

        computer.getPrice();

    }
}
