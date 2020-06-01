package com.junjunlei.review.producter_consumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 资源类
 * 基于lock
 *
 * @author junjun.lei
 * @create 2020-06-01 12:27
 */
public class Data1 {

    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    //生产==+1
    public void increment() {
        try {
            //加锁
            lock.lock();
            while (number != 0) {
                //等待
                condition.await();
            }
            number++;
            System.out.println(Thread.currentThread().getName() + "==>" + number);
            //通知
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            //解锁
            lock.unlock();
        }
    }

    //消费==-1
    public void decrement() {
        try {
            lock.lock();
            while (number == 0) {
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "==>" + number);
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
