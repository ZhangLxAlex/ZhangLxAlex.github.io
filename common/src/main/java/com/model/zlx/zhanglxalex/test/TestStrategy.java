package com.model.zlx.zhanglxalex.test;

/**
 * @ClassName TestStrategy
 * @Author zhang_lx
 * @Date 2020/8/25 下午3:14
 * @Version 1.0
 */
public class TestStrategy {

    public static void main(String[] args) {
        Context context = new Context(new GoClimb());
        System.out.println(context.executeStrategy("晴天"));
    }

}