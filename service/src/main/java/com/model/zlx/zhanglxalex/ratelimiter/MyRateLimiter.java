package com.model.zlx.zhanglxalex.ratelimiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyRateLimiter
 * @Author zhang_lx
 * @Date 2023/11/15 下午5:12
 * @Version 1.0
 */
@Slf4j
public class MyRateLimiter {

    public static void main(String[] args) {
//        test1();
        test2();
    }

    public static void test1() {
        // 新建一个每秒限制3个的令牌桶
        RateLimiter rateLimiter = RateLimiter.create(3);
        // 每秒只能执行三次（qps=3）
        for (int i = 0; i < 20; i++) {
            //阻塞直到可以授予请求,acquire是距离上次执行的时间
            double acquire = rateLimiter.acquire();
            System.out.println(acquire);
            log.info("发送了短信：" + i);
        }
    }

    public static void test2() {
        //新建一个每秒限制3个的令牌桶
        RateLimiter rateLimiter = RateLimiter.create(3.0);
        ExecutorService executor = Executors.newFixedThreadPool(16);
        for (int i = 0; i < 10; i++) {
            executor.execute(() -> {
                //获取令牌桶中一个令牌，最多等待10秒
                boolean res = rateLimiter.tryAcquire(1, 10, TimeUnit.SECONDS);
                if (res) {
                    log.info("得到了许可");
                }
            });
        }
        executor.shutdown();
    }

}
