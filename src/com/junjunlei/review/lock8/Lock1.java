package com.junjunlei.review.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 线程8锁问题（面试重点）
 *
 * 1.标准情况  先打印短信还是电话？  1.短信  2.电话
 *
 * 2.发送短信延迟四秒  先打印短信还是电话？ 1.短信 2.电话
 * @author junjun.lei
 * @create 2020-06-01 14:18
 */
public class Lock1 {
    public static void main(String[] args) {
        Phone phone = new Phone();

        //锁存在
        new Thread(()->{
            phone.send();
        },"A").start();

        new Thread(()->{
            phone.call();
        },"B").start();
    }
}

class Phone {

    //synchronized 锁的是方法的调用者
    public synchronized void send() {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public synchronized void call() {
        System.out.println("打电话");
    }
}