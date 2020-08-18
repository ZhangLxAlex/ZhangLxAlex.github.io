package com.model.zlx.zhanglxalex.lamb;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName StreamMap1
 * @Author zhang_lx
 * @Date 2020-08-10 10:46
 * @Version 1.0
 */
public class StreamMap1 {

    public static void main(String[] args) {

        List<String> players = Arrays.asList("kobe", "james", "curry", "cyyt");

        //目的转大写
        List<String> list = players.stream()
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        List<String> list1 = players.stream()
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        System.out.println(list);

        //map其他操作
        players.stream()
                .mapToInt(String::length)
                .forEach(System.out::println);

    }

}
