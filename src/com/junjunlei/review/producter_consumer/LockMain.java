package com.junjunlei.review.producter_consumer;

/**
 * 线程 操作 资源类
 * @author junjun.lei
 * @create 2020-06-01 12:41
 */
public class LockMain {
    public static void main(String[] args) {
        Data1 data = new Data1();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.increment();
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.decrement();
            }
        }, "B").start();
    }
}
