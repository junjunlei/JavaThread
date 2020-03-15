package com.junjunlei.base.o3;

/**
 * 测试Thread中的常用方法：
 * 1.start():启动当前线程；调用线程的run()
 * 2.run() 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3.currentThread() 静态方法，返回指向当前代码的线程
 * 4.getName()获取当前线程的名字
 * 5.setName()设置当前线程的名字
 * 6.yield()线程让步 释放当前cpu的执行权
 * 7.join()当A线程调用线程B的join()，线程A进入阻塞状态，知道线程B执行完
 * 8.stop() 强制结束线程，此方法已过时
 * 9.sleep(long millis)
 * <p>  /praɪˈɒrəti/
 * 线程的优先级：
 *  线程的优先级等级
 * MAX_PRIORITY：10
 * MIN _PRIORITY：1
 * NORM_PRIORITY：5
 *  涉及的方法
 * getPriority() ：返回线程优先值
 * setPriority(int newPriority) ：改变线程的优先级
 *  说明
 * 线程创建时继承父线程的优先级
 * 低优先级只是获得调度的概率低，并非一定是在高优先级线程之后才被调用
 *
 * @author junjun.lei
 * @create 2020-03-14 20:39
 */
public class Main {
    public static void main(String[] args) {
        Thread.currentThread().setName("Main");
        ThreadMethod mt = new ThreadMethod();
        mt.setName("Thread-0");
        mt.start();
        int num = 100;
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }
            if (i == 20) {
                try {
                    mt.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
