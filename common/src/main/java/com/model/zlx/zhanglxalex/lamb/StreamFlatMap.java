package com.model.zlx.zhanglxalex.lamb;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName StreamFlatMap
 * @Author zhang_lx
 * @Date 2020-08-10 11:22
 * @Version 1.0
 */
public class StreamFlatMap {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("hello", "word");

        //java.util.stream.ReferencePipeline$Head@3d646c37
        //java.util.stream.ReferencePipeline$Head@41cf53f9
        //输出两个管道流
        words.stream()
                .map(w -> Arrays.stream(w.split("")))    //[[h,e,],[]]
                .forEach(System.out::println);

        //flatMap,处理多维数组，两个for等
        words.stream()
                .flatMap(w -> Arrays.stream(w.split("")))
                .forEach(System.out::println);

    }

}
