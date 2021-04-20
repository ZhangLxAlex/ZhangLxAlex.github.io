package com.model.zlx.zhanglxalex.javatest;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    public static void main(String[] args) {

        Print123 print123 = new Print123();

        // 线程a
        Thread threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print123.print1();
            }
        }, "a");
        threadA.start();

        // 线程b
        Thread threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print123.print2();
            }
        }, "b");
        threadB.start();

        // 线程c
        Thread threadC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                print123.print3();
            }
        }, "c");
        threadC.start();

    }

}

class Print123 {

    /**
     * flag标示位
     */
    private int flag = 1;



    /**
     * 输出1
     */
    public synchronized void print1() {
        while (flag != 1) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flag = 2;
        System.out.println("1" + "," + Thread.currentThread().getName());
        this.notifyAll();
    }

    /**
     * 输出2
     */
    public synchronized void print2() {
        while (flag != 2) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flag = 3;
        System.out.println("2" + "," + Thread.currentThread().getName());
        this.notifyAll();
    }

    /**
     * 输出3
     */
    public synchronized void print3() {
        while (flag != 3) {
            try {
                this.wait();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        flag = 1;
        System.out.println("3" + "," + Thread.currentThread().getName());
        this.notifyAll();
    }


}
