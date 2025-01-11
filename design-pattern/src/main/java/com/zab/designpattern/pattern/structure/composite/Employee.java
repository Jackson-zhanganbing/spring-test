package com.zab.designpattern.pattern.structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 员工
 *
 * @author zab
 * @date 2025/1/11 15:06
 */
public class Employee {
    private String name;
    private String dept;
    private int salary;
    //下属/səˈbɔːdɪneɪts/
    private List<Employee> subordinates;

    public Employee(String name,String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        subordinates = new ArrayList<Employee>();
    }

    public void add(Employee e) {
        subordinates.add(e);
    }

    public void remove(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates(){
        return subordinates;
    }

    @Override
    public String toString(){
        return ("Employee :[ Name : "+ name
                +", dept : "+ dept + ", salary :"
                + salary+" ]");
    }
}