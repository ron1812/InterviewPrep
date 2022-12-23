package com.practice.core;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparableTutorial {

    public static void main(String[] args) {
        SubjectV2 s1 = new SubjectV2();
        SubjectV2 s2 = new SubjectV2();
        SubjectV2 s3 = new SubjectV2();

        s1.setGrade(0);
        s2.setGrade(-1);
        s3.setGrade(3);

        TreeSet<SubjectV2> treeSub = new TreeSet<>();
        treeSub.add(s1);
        treeSub.add(s2);
        treeSub.add(s3);

        treeSub.forEach(x -> System.out.println(x.toString()));


        // ************************** Without comparable ***********************

        System.out.println("************************** Without comparable but passing through comparator ***********************");

        SubjectWithoutComparable withoutComparable = new SubjectWithoutComparable();
        SubjectWithoutComparable withoutComparable1 = new SubjectWithoutComparable();
        SubjectWithoutComparable withoutComparable2 = new SubjectWithoutComparable();

        withoutComparable.setGrade(0);
        withoutComparable1.setGrade(-1);
        withoutComparable2.setGrade(3);

        TreeSet<SubjectWithoutComparable> treeSub2 = new TreeSet<>(Comparator.comparing(SubjectWithoutComparable::getGrade).reversed());
        treeSub2.add(withoutComparable);
        treeSub2.add(withoutComparable1);
        treeSub2.add(withoutComparable2);

        treeSub2.forEach(x -> System.out.println(x.toString()));

    }

}

class SubjectV2 implements Comparable<SubjectV2>{

    @Override
    public int compareTo(SubjectV2 s2) {
        if(this.getGrade().equals(s2.getGrade()))
            return 0;
        else if(this.getGrade() > s2.getGrade())
            return 1;
        else
            return -1;
    }

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

class SubjectWithoutComparable {

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
