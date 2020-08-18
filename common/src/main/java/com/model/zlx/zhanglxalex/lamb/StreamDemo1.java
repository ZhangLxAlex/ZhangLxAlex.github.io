package com.model.zlx.zhanglxalex.lamb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamDemo1
 * @Author zhang_lx
 * @Date 2020-08-07 14:41
 * @Version 1.0
 */
public class StreamDemo1 {

    public static void main(String[] args) throws IOException {

        //1、集合转流
        List<String> players = Arrays.asList("kobe", "james", "curry", "cyyt");

        //iter,不用流麻烦
        /*for (String player : players) {
            if(player.startsWith("L")){
                String temp = player.toUpperCase();
            }
        }*/

        //filter意思是留下来,过滤的意思
        //map的意思是对数据做下处理
        List<String> sorted = players.stream()
                .filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        System.out.println(sorted);

        //2、数组转流
        String[] plays = {"kobe", "james", "curry", "cyyt"};
        List<String> playsSorted = Stream.of(plays).filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        //3、set转流
        Set<String> sort = new HashSet<>(players);
        sort.stream().filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        //4、文本文件转流
        //Stream<String> stream = Files.lines(Paths.get("file.txt"));

        //Collectors可以toList，toMap，toSet等

        sort.stream().filter(s -> s.startsWith("c"))
                .map(String::toUpperCase)
                .forEach(s -> System.out.println(s)
                );

    }

}
