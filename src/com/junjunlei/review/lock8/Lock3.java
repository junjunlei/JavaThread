package com.junjunlei.review.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 线程8锁
 *  5.两个静态同步方法，一个对象，先短信还是先电话？  短信
 *  6.两个对象，两个静态同步方法，先短信还是电话？  短信
 * @author junjun.lei
 * @create 2020-06-01 14:40
 */
public class Lock3 {
    public static void main(String[] args) {
        //两个Phone3对象 但是是一个Class模板
        Phone3 phone3 = new Phone3();
        Phone3 phone4 = new Phone3();
        //锁存在
        new Thread(()->{
            phone3.send();
        },"A").start();

        new Thread(()->{
            phone4.call();
        },"B").start();
    }
}

class Phone3 {
    //静态同步方法 锁的是类
    public static synchronized void send() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}
