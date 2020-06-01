package com.junjunlei.review.lock8;

import java.util.concurrent.TimeUnit;

/**
 * 线程8锁
 * <p>
 * 3.增加普通方法sayHello ，先执行普通方法还是发短信的方法？ 普通方法
 * 4.两个对象，两个同步方法，先打电话还是先发短信？  先打电话
 * @author junjun.lei
 * @create 2020-06-01 14:30
 */
public class Lock2 {
    public static void main(String[] args) {
        //两个对象，两个调用者，两把锁
        Phone2 phone1 = new Phone2();
        Phone2 phone2 = new Phone2();
        new Thread(() -> {
            phone1.send();
        }, "A").start();

        new Thread(() -> {
            //phone1.sayHello();
            phone2.call();
        }, "B").start();
    }
}

class Phone2 {

    //非静态方法锁的是对象
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

    //非同步方法不受影响
    public void sayHello() {
        System.out.println("hello");
    }
}