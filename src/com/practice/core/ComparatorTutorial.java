package com.practice.core;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorTutorial {

    public static void main(String[] args) {

        Subject s1 = new Subject();
        Subject s2 = new Subject();
        Subject s3 = new Subject();

        s1.setGrade(-1);
        s2.setGrade(-2);
        s3.setGrade(-3);

        Comparator<Subject> subjectComparator = new Comparator<Subject>() {

            @Override
            public int compare(Subject s1, Subject s2) {
                if(s1.getGrade().equals(s2.getGrade()))
                    return 0;
                else if(s1.getGrade() > s2.getGrade())
                    return 1;
                else
                    return -1;
            }
        };

        TreeSet<Subject> treeSub = new TreeSet<>(subjectComparator);
        treeSub.add(s1);
        treeSub.add(s2);
        treeSub.add(s3);

        treeSub.stream().forEach(x -> System.out.println(x.toString()));
    }
}

class Subject{

    private String name;
    private Integer grade;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
