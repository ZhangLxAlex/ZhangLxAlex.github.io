package com.model.zlx.zhanglxalex.lamb.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Predicate;

/**
 * @ClassName Employee
 * @Author zhang_lx
 * @Date 2020-08-10 09:50
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class Employee {

    private Integer id;

    private Integer age;

    private String gender;

    private String firstName;

    private String lastName;

    /**
     * 年龄大于70谓词逻辑
     */
    public static Predicate<Employee> aveGenaterThan70 = x -> x.getAge() > 70;

    /**
     * 男性谓词逻辑
     */
    public static Predicate<Employee> genderM = x -> x.getGender().equals("M");

}
