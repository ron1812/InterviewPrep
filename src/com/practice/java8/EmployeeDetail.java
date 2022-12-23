package com.practice.java8;

import javafx.util.Pair;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class EmployeeDetail {

    public static void main(String[] args) {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1,1000,1,"active","Rohan"));
        employeeList.add(new Employee(2,1000,1,"active","Ankit"));
        employeeList.add(new Employee(3,500,1,"inactive","Amit"));
        employeeList.add(new Employee(2,2000,2,"active","Pritish"));
        employeeList.add(new Employee(2,2000,2,"active","Pritish"));
        employeeList.add(new Employee(4,1500,2,"active","Jessy"));

        // Practice

//        employeeList.stream().max(Comparator.comparingInt(Employee::getSalary));
//        employeeList.stream().min(Comparator.comparingInt(Employee::getSalary));
//
//        Map<Integer, Employee> collect2 = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getDepId,Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)),Optional::get)));

        TreeMap<Integer, Set<Employee>> collect2 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepId, TreeMap::new, Collectors.toSet()));

        Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting());

        // Practice

        Optional < Employee > maxSalary = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println("MAX SALARY "+maxSalary.get().getSalary());

        Optional<Employee> minSalary = employeeList.stream().min(Comparator.comparing(Employee::getSalary));
        System.out.println("MIN SALARY "+minSalary.get().getSalary());

        ///// ********************************** Non match **************************************/////

        System.out.println("No one has salary equal to 2000 ? : "+employeeList.stream().noneMatch(x -> x.getSalary() == 2000));

        ///// ********************************** All match **************************************/////

        System.out.println("Does everyone have salary above 499 : "+employeeList.stream().allMatch(x -> x.getSalary() > 499));

        ///// ********************************** Any match **************************************/////

        System.out.println("Does anyone have name as amit : "+employeeList.stream().anyMatch(x -> x.getName().equalsIgnoreCase("Amit")));

        ////////// *********************** Compare by salary if same then compare by name ********************************

        System.out.println("////////// *********************** Compare by salary if same then compare by name ***************************/////");
        List<Employee> sortSalryThenName = employeeList.stream().sorted(Comparator.comparingInt(Employee::getSalary).thenComparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(sortSalryThenName);

        ////////// *********************** Find max salary per department ********************************

        Map<Integer, Optional<Employee>> collectOptional = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepId, Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));

        Map<Integer, Employee> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepId, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparingInt(Employee::getSalary)), Optional::get)));

        collect.entrySet().stream().forEach(x -> {
            System.out.println("Department Id "+x.getKey()+" has max salary as "+x.getValue().getSalary());
        });

        ////////// *********************** Find max salary per department ALTERNATE WAY ********************************

        System.out.println("////////// *********************** ALTERNATE WAY ********************************//////////////");

        Map<Integer, Optional<Employee>> collect1 = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepId, Collectors.reducing(BinaryOperator.maxBy(Comparator.comparing(Employee::getSalary)))));

        collect1.entrySet().stream().forEach(x -> {
            System.out.println("Department Id "+x.getKey()+" has max salary as "+x.getValue().get().getSalary());
        });

        ////////// *********************** END ********************************

        ///////// *********************** Find average salary per department *******************************

        System.out.println("////////// *********************** Find average salary per department  ********************************//////////////");

        Map<Integer, Double> depToAvgSal = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepId, Collectors.averagingInt(Employee::getSalary)));

        depToAvgSal.entrySet().stream().forEach(x -> {
            System.out.println("Department Id "+x.getKey()+" has avg salary as "+x.getValue());
        });

        ///////// *********************** Partition by salary below and above 1000 *******************************

        System.out.println("***********************************");

        Map<Boolean, List<Employee>> salaryPartition = employeeList.stream().collect(Collectors.partitioningBy(x -> x.getSalary() > 1000));

        salaryPartition.entrySet().forEach(j -> {
            if(j.getKey()){

                System.out.println("Salary above 1000 employee list");
            }else{

                System.out.println("Salary below 1000 employee list");
            }

            List<Employee> value = j.getValue();
            value.stream().forEach(t -> System.out.println(t.getName()));

            System.out.println("***********************************");
        });

        ///////// *****************************************************
    }
}

class Employee{
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", depId=" + depId +
                ", status='" + status + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    private int id;
    private Integer salary;
    private int depId;
    private String status;
    private String name;

    public Employee(int id, int salary, int depId, String status,String name) {
        this.id = id;
        this.salary = salary;
        this.depId = depId;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String status) {
        this.name = name;
    }


}
