package com.model.zlx.zhanglxalex.lamb;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @ClassName StreamState
 * @Author zhang_lx
 * @Date 2020/8/18 下午3:50
 * @Version 1.0
 */
public class StreamState {

    public static void main(String[] args) {

        //有状态的不能用并行的.parallel()
        //并行api适合数组、arrayList、hashMap，适合无状态操作

        //取前N个
        List<String> limilN = Stream.of("Money", "Lion", "Giraffe", "Lemur")
                .limit(2)
                .collect(Collectors.toList());
        System.out.println(limilN);

        //跳过前N个
        List<String> skipN = Stream.of("Money", "Lion", "Giraffe", "Lemur")
                .skip(2)
                .collect(Collectors.toList());
        System.out.println(skipN);

        //去重
        List<String> uniqueAnimals = Stream.of("Money", "Lion", "Giraffe", "Lemur", "Lion")
                .distinct()
                .collect(Collectors.toList());
        System.out.println(uniqueAnimals);

        //排序
        List<String> alphabeticOrder = Stream.of("Money", "Lion", "Giraffe", "Lemur")
                .sorted()
                .collect(Collectors.toList());
        System.out.println(alphabeticOrder);

    }

}
