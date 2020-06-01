package com.junjunlei.review.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 线程8锁
 * <p>
 * 7.一个静态同步方法，一个普通同步方法  一个对象 先短信还是先电话? 打电话
 * 8.一个静态同步方法，一个普通同步方法  两个对象 先短信还是先电话? 打电话
 *
 *   不同锁互不影响，也就是不是一把锁
 *
 * @author junjun.lei
 * @create 2020-06-01 17:31
 */
public class Lock4 {
    public static void main(String[] args) {
        //两个Phone3对象 但是是一个Class模板
        Phone4 phone3 = new Phone4();
        Phone4 phone4 = new Phone4();
        //锁存在
        new Thread(() -> {
            phone3.send();
        }, "A").start();

        new Thread(() -> {
            phone4.call();
        }, "B").start();
    }
}

class Phone4 {

    //静态 synchronized 锁的Class模板
    public static synchronized void send() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    //非静态 锁的是对象
    public synchronized void call() {
        System.out.println("打电话");
    }
}
