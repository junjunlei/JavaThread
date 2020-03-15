package com.junjunlei.base.o4;

/**
 * 线程买票问题 继承Thread
 *    存在线程安全问题：
 * @author junjun.lei
 * @create 2020-03-14 21:20
 */
public class TicketThread extends Thread {
    /**
     * 火车票100张
     */
    private static int ticket=100;
    @Override
    public void run() {
        while (true){
            if(ticket>0){
                System.out.println(getName()+":"+"卖票票号为："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}
