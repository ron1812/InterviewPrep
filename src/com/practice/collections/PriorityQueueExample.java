package com.practice.collections;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueExample {

    public static void main(String[] args) {
        PriorityQueue<Student> minPriority = new PriorityQueue<>(Comparator.comparingInt(a -> a.score));
        minPriority.offer(new Student(12,80,"Rohan"));
        minPriority.offer(new Student(16,98,"Jessy"));
        minPriority.offer(new Student(20,100,"Ankit"));

        System.out.println("Removing top 2 min priority records based on score");
        System.out.println(minPriority.poll().name);
        System.out.println(minPriority.poll().name);


        PriorityQueue<Student> maxPriority = new PriorityQueue<>((a,b) -> b.score - a.score);
        maxPriority.offer(new Student(12,80,"Rohan"));
        maxPriority.offer(new Student(16,98,"Jessy"));
        maxPriority.offer(new Student(20,100,"Ankit"));

        System.out.println("Removing top 2 max priority records based on score");
        System.out.println(maxPriority.poll().name);
        System.out.println(maxPriority.poll().name);
    }
}

class Student {

    public String name;
    public Integer score;
    public Integer age;

    public Student(Integer age,Integer score,String name){
        this.age = age;
        this.score = score;
        this.name = name;
    }
}
