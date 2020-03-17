package com.junjunlei.base.o11;

/**
 * @author junjun.lei
 * @create 2020-03-17 23:03
 */
public class Main {
    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Productor productor=new Productor(clerk);
        productor.setName("生产者");
        Consumer consumer1=new Consumer(clerk);
        consumer1.setName("消费者1");
        Consumer consumer2=new Consumer(clerk);
        consumer2.setName("消费者2");
        productor.start();
        consumer1.start();
        consumer2.start();
    }
}
