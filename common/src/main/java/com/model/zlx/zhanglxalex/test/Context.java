package com.model.zlx.zhanglxalex.test;

/**
 * @ClassName Context
 * @Author zhang_lx
 * @Date 2020/8/25 下午3:09
 * @Version 1.0
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public String executeStrategy(String weather){

        return strategy.doSoming(weather);

    }

}
