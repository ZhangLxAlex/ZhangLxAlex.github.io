package com.model.zlx.zhanglxalex.lamb;

import com.model.zlx.zhanglxalex.lamb.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamFilterPredicate
 * @Author zhang_lx
 * @Date 2020-08-10 09:53
 * @Version 1.0
 */
public class StreamFilterPredicate {

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

        //复习，过滤操作
        List<Employee> list = employees.stream()
                .filter(employee -> employee.getAge() > 70 && employee.getGender().equals("M"))
                .collect(Collectors.toList());

        System.out.println(list);

        //重点接口Predicate：谓语，说白了对主语的限定条件，谓词逻辑
        //Stream<T> filter(Predicate<? super T> predicate);

        //将上述filter条件抽出到实体类，目的是可复用
        //.negate()去反
        List<Employee> list1 = employees.stream()
                .filter(
                        Employee.aveGenaterThan70
                                .and(Employee.genderM)
                )
                .collect(Collectors.toList());

        System.out.println(list1);

    }

}
