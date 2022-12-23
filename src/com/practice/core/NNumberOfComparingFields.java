package com.practice.core;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class NNumberOfComparingFields {

    public static void main(String[] args) {
          List<Person> personList = Arrays.asList(new Person("1","ankit","uk"),new Person("1","ankit","india"));
          String[] criteria = {"id","major","address"};
          sort(personList,criteria);

          personList.forEach(System.out::println);
    }

    public static List<Person> sort(List<Person> personUnsortedList, String[] criteria){
        GeneralComparator g = new GeneralComparator(criteria);

        personUnsortedList.sort(g);

        return personUnsortedList;
    }
}

class GeneralComparator implements Comparator<Person> {

    String[] criteria;

    public GeneralComparator(String[] criteria){
        this.criteria = criteria;
    }
    @Override
    public int compare(Person p1, Person p2) {
        int counter = 0;
        for(String criteriaStr: criteria){
            if(!checkForEquality(p1,p2,criteriaStr)){
                break;
            }
            counter++;
        }
        return p1.getProperty(criteria[counter]).compareTo(p2.getProperty(criteria[counter]));
    }

    public boolean checkForEquality(Person p1, Person p2,String criteriaStr){
        String propertyPerson1 = p1.getProperty(criteriaStr);
        String propertyPerson2 = p2.getProperty(criteriaStr);

        int i = propertyPerson1.compareTo(propertyPerson2);
        return i == 0;
    }
}

class Person {

    private String id;
    private String major;
    private String address;

    public Person(String id,String major,String address){
        this.id = id;
        this.major = major;
        this.address = address;
    }

    public String getProperty(String property){
        try{
            return (String)this.getClass().getDeclaredField(property).get(this);
        }catch (Exception e){
            throw new RuntimeException("Field passed in does not exist");
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", major='" + major + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
