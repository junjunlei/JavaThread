package com.junjunlei.base.o11;

/**
 * @author junjun.lei
 * @create 2020-03-16 20:29
 */
public class Consumer extends Thread {
    Clerk clerk;
    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }
    @Override
    public  void run() {
        System.out.println("消费者开始取走产品");
        while (true){
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            clerk.getProduct();
        }
    }
}
