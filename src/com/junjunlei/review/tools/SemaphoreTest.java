package com.junjunlei.review.tools;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * 信号量
 *   两个作用：
 *         1.多个共享资源互斥使用
 *         2.控制并发线程数
 * @author junjun.lei
 * @create 2020-06-01 23:57
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for(int i=0;i<6;i++) {
            new Thread(()->{
                try {
                    //抢占--会阻塞
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了车位");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName()+"离开了车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放
                    semaphore.release();
                }

            }).start();
        }
    }
}
