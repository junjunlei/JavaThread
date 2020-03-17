package com.junjunlei.base.o11;

/**
 *
 * 线程通信的应用：经典例题：生产者/消费者问题
 *
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Consumer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，店员
 * 会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品
 * 了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 *
 * 分析：
 * 1. 是否是多线程问题？是，生产者线程，消费者线程
 * 2. 是否有共享数据？是，店员（或产品）
 * 3. 如何解决线程的安全问题？同步机制,有三种方法
 * 4. 是否涉及线程的通信？是
 *
 * @author junjun.lei
 * @create 2020-03-16 20:29
 */
public class Clerk {
    private int product=0;
    public synchronized void addProduct(){
        if(product>20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            product++;
            System.out.println(Thread.currentThread().getName()+"生产者生产了第"+product+"个产品");
            notify();
        }
    }
    public synchronized void getProduct(){
        if(product>0){
            System.out.println(Thread.currentThread().getName()+"消费者取走了第"+product+"个产品");
            product--;
            notify();
        }else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
