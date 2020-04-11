package com.junjunlei.juc.o4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：两个线程，可以操作初始值为0的一个变量，
 * 实现一个线程加1一个线程变量减1
 * 实现交替。10轮
 * <p>
 * 1.高内聚低耦合前提下，线程操作资源类
 * 2. 判断/干活/通知
 * 3.多线程交互中，必要防止多线程的虚假唤醒也即（判断只用 while 不能用if）
 *
 * @author junjun.lei
 * @create 2020-04-11 0:21
 */
public class ThreadWaitNotifyDemo {
    public static void main(String[] args) {
        AirConditioner airConditioner = new AirConditioner();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "A").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "B").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.increment();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "C").start();
        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                try {
                    airConditioner.decrement();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "D").start();
    }
}

class AirConditioner {
    private int number = 0;
    private Lock lock = new ReentrantLock();

    //lock的唤醒等待

    private Condition condition = lock.newCondition();

    public void increment() {
        lock.lock();
        try {
            while (number != 0) {
                condition.await();
            }
            //2.干活
            number++;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void decrement() {
        lock.lock();
        try {
            //1.判断
            while (number == 0) {
                condition.await();
            }
            //2.干活
            number--;
            System.out.println(Thread.currentThread().getName() + "\t" + number);
            //3.通知
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

//    public synchronized void increment() throws InterruptedException {
//        //1.判断  切记不要用if  会造成虚假唤醒
//       while (number != 0) {
//            this.wait();
//        }
//        //2.干活
//        number++;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //3.通知
//        this.notify();
//    }
//
//    public synchronized void decrement() throws InterruptedException {
//        //1.判断
//        while (number == 0) {
//            this.wait();
//        }
//        //2.干活
//        number--;
//        System.out.println(Thread.currentThread().getName()+"\t"+number);
//        //3.通知
//        this.notify();
//    }
}
