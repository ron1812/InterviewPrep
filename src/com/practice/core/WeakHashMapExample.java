package com.practice.core;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapExample {

    /*
    There are several important features of WeakHashMap in Java that should keep in mind. They are as follows:

    1. Garbage collector may remove keys and their associated values from the WeakHashMap at any time in java.
    2. It enables us to store data in form of key-value pairs in java.
    3. Java WeakHashMap does not allow storing duplicate keys.
    4. It allows to insert only one null key in the map but several null values can be added.
    5. WeakHashMap does not maintain insertion order in java.
    6. WeakHashMap in Java is not synchronized. So, it is not thread-safe. Two or more threads on the same WeakHashMap object can access at the same time in java.
     */
    public static void main(String[] args) {
        Employee rohan = new Employee(1, 1000, 1, "Rohan");
        Employee ankit = new Employee(2, 1000, 1, "Ankit");;
        Employee amit = new Employee(3, 500, 1, "Amit");

        WeakHashMap<Employee,Integer> map = new WeakHashMap<>();
        //HashMap<Employee,Integer> map = new HashMap<>();
        map.put(rohan,1);
        map.put(ankit,2);
        map.put(amit,3);

        rohan = null;

        System.gc();

        map.entrySet().stream().forEach(x -> System.out.println("Employee Name "+x.getKey().getName()+" : Integer "+x.getValue()));
    }
}

class Employee{

    private int id;
    private int salary;
    private int depId;
    private String name;

    public Employee(int id, int salary, int depId, String name) {
        this.id = id;
        this.salary = salary;
        this.depId = depId;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getName() {
        return name;
    }

    public void setName(String status) {
        this.name = name;
    }
}
