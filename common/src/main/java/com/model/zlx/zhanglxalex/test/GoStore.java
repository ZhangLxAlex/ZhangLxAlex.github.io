package com.model.zlx.zhanglxalex.test;

/**
 * @ClassName GoStore
 * @Author zhang_lx
 * @Date 2020/8/25 下午3:06
 * @Version 1.0
 */
public class GoStore implements Strategy {


    @Override
    public String doSoming(String weather) {
        return "开车去商场";
    }

}
