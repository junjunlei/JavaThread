package com.junjunlei.base.o8;

import java.util.concurrent.locks.ReentrantLock;

/**
 *
 *
 * 解决线程安全问题的方式三：Lock锁  --- JDK5.0新增
 *
 * 1. 面试题：synchronized 与 Lock的异同？
 *   相同：二者都可以解决线程安全问题
 *   不同：synchronized机制在执行完相应的同步代码以后，自动的释放同步监视器
 *        Lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 * 2.优先使用顺序：
 * Lock  同步代码块（已经进入了方法体，分配了相应资源）  同步方法（在方法体之外）
 *
 *
 *  面试题：如何解决线程安全问题？有几种方式
 * @author junjun.lei
 * @create 2020-03-15 17:33
 */
public class LockThread implements Runnable {
    /**
     * 火车票100张
     */
    private int ticket = 100;
    private ReentrantLock lock = new ReentrantLock(true);
    @Override
    public void run() {
        while (true) {
            try {
                //调用锁定方法
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":" + "卖票票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //调用解锁方法
                lock.unlock();
            }
        }
    }
}
