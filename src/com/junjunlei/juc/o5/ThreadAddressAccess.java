package com.junjunlei.juc.o5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 多线程之间顺序调用，实现 A>B>C
 * 三个线程启动，要求如下：
 * AA打印5次，BB打印10次，CC打印15次
 * 十轮
 *
 * @author junjun.lei
 * @create 2020-04-11 8:35
 */
public class ThreadAddressAccess {
    public static void main(String[] args) {
        ShareResource shareResource=new ShareResource();
        new Thread(()->{for(int i=1;i<=10;i++){shareResource.printAA();}},"AA").start();
        new Thread(()->{for(int i=1;i<=10;i++){shareResource.printBB();}},"BB").start();
        new Thread(()->{for(int i=1;i<=10;i++){shareResource.printCC();}},"CC").start();
    }
}

class ShareResource {
    /**
     * 标志位
     */
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void printAA() {
        lock.lock();
        try {
            //判断
            while (number != 1) {
                condition1.await();
            }
            //干活
            for (int i = 1; i <= 5; i++) {
                System.out.println(Thread.currentThread().getName() +" : "+"AA");
            }
            //通知
            number = 2;
            condition2.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }

    public void printBB() {
        lock.lock();
        try {
            //判断
            while (number != 2) {
                condition2.await();
            }
            //干活
            for (int i = 1; i <= 10; i++) {
                System.out.println(Thread.currentThread().getName() +" : "+"BB");
            }
            //通知
            number = 3;
            condition3.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }


    public void printCC() {
        lock.lock();
        try {
            //判断
            while (number != 3) {
                condition3.await();
            }
            //干活
            for (int i = 1; i <= 15; i++) {
                System.out.println(Thread.currentThread().getName() +" : "+"CC");
            }
            //通知
            number = 1;
            condition1.signal();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }

    }
}