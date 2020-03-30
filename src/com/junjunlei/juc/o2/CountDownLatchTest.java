package com.junjunlei.juc.o2;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 *
 * @author junjun.lei
 * @create 2020-03-30 12:23
 */
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(100);
        LatchThread latchThread = new LatchThread(countDownLatch);

        int num = 100;
        for (int i = 0; i < num; i++) {
            new Thread(latchThread).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class LatchThread implements Runnable {

    private CountDownLatch countDownLatch;

    public LatchThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        int num = 100;
        try {
            for (int i = 0; i < num; i++) {
                if (i%2 == 0) {
                    System.out.println(Thread.currentThread().getName()+":"+i);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println(countDownLatch.getCount());
            countDownLatch.countDown();
        }
    }
}