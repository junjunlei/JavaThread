package com.junjunlei.review.producter_consumer;

/**
 * 线程-操作-资源类
 * <p>
 * 资源类
 *
 *
 * @author junjun.lei
 * @create 2020-06-01 10:54
 */
public class Data {

    public int number;

    //生产==+1
    public synchronized void increment() throws InterruptedException {
        //使用while循环防止虚假唤醒
        while (number != 0) {
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName() + "===>" + number);
        this.notifyAll();
    }

    //消费==-1
    public synchronized void decrement() throws InterruptedException {
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName() + "===>" + number);
        this.notifyAll();
    }
}
