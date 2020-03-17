package com.junjunlei.base.o11;

/**
 * @author junjun.lei
 * @create 2020-03-16 20:29
 */
public class Productor extends Thread {
    Clerk clerk;

    public Productor(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println("生产者开始生产产品");
        while (true) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.addProduct();
        }
    }
}
