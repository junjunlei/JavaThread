package com.junjunlei.aqs;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS抽象队列同步器
 *
 * @author junjun.lei
 * @create 2020-05-02 16:32
 */
public class AbstractQueuedSynchronizerDemo {
    public static void main(String[] args) {

        AbstractQueuedSynchronizerDemo aqsd=new AbstractQueuedSynchronizerDemo();

        new Thread(()->{aqsd.modifyResources(Thread.currentThread().getName());},"junjunlei").start();
    }

    Lock lock = new ReentrantLock(true);
    int counter=0;
    public void modifyResources(String threadName) {
        System.out.println("通知管理员  线程：----->" + threadName + "准备打水");
        lock.lock();
            System.out.println();
            System.out.println("线程："+threadName+"第一次加锁");
            counter++;
            //可重入锁
            lock.lock();
            System.out.println("线程："+threadName+"第二次加锁");
            counter++;
            System.out.println("线程: " + threadName + "打第"+counter+"桶水");
            lock.unlock();
            System.out.println("线程："+threadName+"释放第一个锁");
        lock.unlock();
        System.out.println("线程："+threadName+"释放第二个锁");
    }
}
