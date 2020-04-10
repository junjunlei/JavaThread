package com.junjunlei.juc.o3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目： 三个售票员 卖出  30张票
 * <p>
 * 多线程编程企业级套路 + 模板
 * 在高内聚低耦合的情况下，   线程   操作（对外暴露的方法）    资源类
 *
 * @author junjun.lei
 * @create 2020-04-10 23:07
 */
public class SaleTicket {
    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        new Thread(() -> {
            while (true) {
                if (ticket.getNumber() > 0) {
                    ticket.saleTicket();
                } else {
                    break;
                }
            }
        }, "A").start();
        new Thread(() -> {
            while (true) {
                if (ticket.getNumber() > 0) {
                    ticket.saleTicket();
                } else {
                    break;
                }
            }
        }, "B").start();
        new Thread(() -> {
            while (true) {
                if (ticket.getNumber() > 0) {
                    ticket.saleTicket();
                } else {
                    break;
                }
            }
        }, "C").start();
    }
}

class Ticket {
    private int number = 60;
    Lock lock = new ReentrantLock();

    public void saleTicket() {
        lock.lock();

        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出第" + (number--) + "还剩下" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int getNumber() {
        return number;
    }
}