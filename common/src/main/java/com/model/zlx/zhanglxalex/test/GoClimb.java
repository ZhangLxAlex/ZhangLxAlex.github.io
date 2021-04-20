package com.model.zlx.zhanglxalex.test;

/**
 * @ClassName GoClimb
 * @Author zhang_lx
 * @Date 2020/8/25 下午3:06
 * @Version 1.0
 */
public class GoClimb implements Strategy {


    @Override
    public String doSoming(String weather) {
        return "就爬山";
    }

}
