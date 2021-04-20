package com.model.zlx.zhanglxalex.test;

import java.util.Scanner;

/**
 * @ClassName Translate
 * @Author zhang_lx
 * @Date 2021/3/9 上午9:19
 * @Version 1.0
 */
public class Translate {

    public static void main(String[] args) {

        boolean flag = true;
        while (flag) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("请输入，回车结束，'#'终止程序：");
            String str = scanner.nextLine();
            if ("#".equals(str)) {
                break;
            }
            translate(str);
        }
    }

    public static void translate(String str) {
        switch (str) {
            case "你好":
                System.out.println("hello");
                break;
            case "世界":
                System.out.println("world");
                break;
            case "人":
                System.out.println("people");
                break;
            case "中国":
                System.out.println("china");
                break;
            case "移动":
                System.out.println("move");
                break;
            case "hello":
                System.out.println("你好");
                break;
            case "world":
                System.out.println("世界");
                break;
            case "people":
                System.out.println("人");
                break;
            case "china":
                System.out.println("中国");
                break;
            case "move":
                System.out.println("移动");
                break;
            default:
                System.out.println("输入有误！");
                break;
        }
    }

}
