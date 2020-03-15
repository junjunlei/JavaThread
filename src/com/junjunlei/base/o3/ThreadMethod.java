package com.junjunlei.base.o3;

/**
 * Thread 类的方法
 * @author junjun.lei
 * @create 2020-03-14 20:27
 */
public class ThreadMethod extends Thread{
    @Override
    public void run() {
        int num = 100;
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if(i%20==0){
                //线程让步
                yield();
                System.out.println("线程让步，哈哈哈");
            }
        }
    }
}
