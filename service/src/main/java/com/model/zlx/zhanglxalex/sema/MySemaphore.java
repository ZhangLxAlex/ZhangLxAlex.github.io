package com.model.zlx.zhanglxalex.sema;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Semaphore;

/**
 * @ClassName MySemaphore
 * @Author zhang_lx
 * @Date 2023/11/15 下午5:07
 * @Version 1.0
 */
@Slf4j
public class MySemaphore {

    public static void main(String[] args) {
        Eat();
    }

    /**
     * 常用于控制某一controller最大并发数，
     * 设置new Semaphore(5)，意思是当前请求最大并发为5
     * 1、请求可以进来，但是没有资源时需要等待。
     * 2、当前controller有资源时，开始处理当前请求。
     * <p>
     * 模拟食堂窗口打饭
     */
    public static void Eat() {

        // 一共有三个窗口
        Semaphore semaphore = new Semaphore(3);

        // 10个同学来打饭
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    log.info("====" + Thread.currentThread().getName() + "来到食堂窗口====");
                    if (semaphore.availablePermits() == 0) {
                        log.info("等待前面同学打饭ing...");
                    }
                    // 如果获取不到令牌则阻塞线程
                    semaphore.acquire();
                    log.info(Thread.currentThread().getName() + "成功打饭");
                    // 模拟打饭时间
                    Thread.sleep(1000 * 2);
                    log.info(Thread.currentThread().getName() + "离开食堂");
                    //释放令牌，让其他线程进入
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }, i + "同学");

            thread.start();

        }
    }

}
