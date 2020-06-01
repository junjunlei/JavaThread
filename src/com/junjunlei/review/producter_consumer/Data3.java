package com.junjunlei.review.producter_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * * 多线程之间顺序调用，实现 A>B>C
 * * 三个线程启动，要求如下：
 * * AA打印5次，BB打印10次，CC打印15次
 * * 十轮
 *
 * @author junjun.lei
 * @create 2020-06-01 13:04
 */
public class Data3 {
    //1=A  2=B  3=C
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition conditionA = lock.newCondition();
    Condition conditionB = lock.newCondition();
    Condition conditionC = lock.newCondition();

    public void printA() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                conditionA.await();
            }
            //执行
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+" : "+"AA");
            }
            number=2;
            //通知
            conditionB.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printB() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                conditionB.await();
            }
            //执行
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+" : "+"BB");
            }
            number=3;
            //通知
            conditionC.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void printC() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                conditionC.await();
            }
            //执行
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+" : "+"CC");
            }
            number=1;
            //通知
            conditionA.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
