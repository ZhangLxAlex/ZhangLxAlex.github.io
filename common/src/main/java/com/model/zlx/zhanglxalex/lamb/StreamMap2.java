package com.model.zlx.zhanglxalex.lamb;

import com.model.zlx.zhanglxalex.lamb.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamMap2
 * @Author zhang_lx
 * @Date 2020-08-10 10:59
 * @Version 1.0
 */
public class StreamMap2 {

    public static void main(String[] args) {

        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan");
        Employee e2 = new Employee(2, 13, "F", "Martina", "Hengist");
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin");
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman");
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria");
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor");
        Employee e7 = new Employee(7, 68, "F", "Melissa", "Roy");
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin");
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh");
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain");

        List<Employee> employees = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        //需求：过了一年，将age加1，将M换成male，将F换成female
        List<Employee> list = employees.stream()
                .map(employee -> {
                    employee.setAge(employee.getAge() + 1);
                    employee.setGender(employee.getGender().equals("M") ? "male" : "female");
                    return employee;
                })
                .collect(Collectors.toList());

        //map也可以换成peek，返回值去掉，特殊的map，传进来的和传出去的是同一个对象，可以省略返回值
        List<Employee> list1 = employees.stream()
                .peek(employee -> {
                    employee.setAge(employee.getAge() + 1);
                    employee.setGender(employee.getGender().equals("M") ? "male" : "female");
                })
                .collect(Collectors.toList());

        System.out.println(list);

    }

}