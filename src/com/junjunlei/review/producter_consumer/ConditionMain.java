package com.junjunlei.review.producter_consumer;

/**
 * 线程通信
 *
 * @author junjun.lei
 * @create 2020-06-01 14:01
 */
public class ConditionMain {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }, "AA").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }, "BB").start();

        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }, "CC").start();
    }
}
