package com.junjunlei.base.o10;

/**
 * @author junjun.lei
 * @create 2020-03-15 23:18
 */
public class Main {
    public static void main(String[] args) {
        CommonicationThread th=new CommonicationThread();
        Thread mt1=new Thread(th);
        Thread mt2=new Thread(th);
        mt1.setName("线程1");
        mt2.setName("线程2");
        mt1.start();
        mt2.start();

    }
}
