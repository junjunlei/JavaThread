package com.junjunlei.base.o4;

/**
 * 火车票卖票问题
 *   创建三个卖票窗口
 * 存在线程安全问题 : 卖出了相同的票
 *   待解决
 * @author junjun.lei
 * @create 2020-03-14 21:26
 */
public class Main {
    public static void main(String[] args) {
        TicketThread wd1=new TicketThread();
        wd1.setName("卖票窗口-1");
        TicketThread wd2=new TicketThread();
        wd2.setName("卖票窗口-2");
        TicketThread wd3=new TicketThread();
        wd3.setName("卖票窗口-3");

        wd1.start();
        wd2.start();
        wd3.start();
    }
}
