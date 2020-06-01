package com.junjunlei.review.tools;

import java.util.concurrent.CountDownLatch;

/**
 * 减法计数器
 *
 *  游戏等待所有人准备好以后 ，开始游戏
 *
 *   他的下一步执行是 main线程
 * @author junjun.lei
 * @create 2020-06-01 22:43
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        //6个人的教室，出去后再锁门
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for(int i=0;i<6;i++){
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"get out");
                countDownLatch.countDown();
            }).start();
        }
        try {
            //等待人全出教室
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("close door");
    }
}
