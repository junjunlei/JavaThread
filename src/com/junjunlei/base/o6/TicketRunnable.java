package com.junjunlei.base.o6;

/**
 * 火车票卖票问题
 *
 * @author junjun.lei
 * @create 2020-03-15 12:04
 */
public class TicketRunnable implements Runnable {
    /**
     * 火车票100张
     */
    private static int ticket = 100;
    Object ob=new Object();
    @Override
    public void run() {
        while (true) {
            //加锁 解决重票 错票问题  操作共享数据的代码即为待同步代码
            synchronized (ob) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":" + "卖票票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}
