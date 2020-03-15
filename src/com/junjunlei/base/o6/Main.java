package com.junjunlei.base.o6;

/**
 *
 * 创建三个窗口卖票 总数100 实现Runnable接口
 * 也存行线程安全问题 待解决
 *
 * 1.问题：卖票过程中，出现了重票、错票----->出现了线程安全问题
 * 2.问题出现原因：当某个线程操作车票得过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3.如何解决：当某个线程a在操作过程ticket过程中，其他线程不能参与进来，直到线程a操作完ticket时，
 *            线程才可以开始操作ticket，这种情况即使线程a出现了阻塞，也不能被改变
 * 4.java中通过同步机制解决线程安全问题
 * @author junjun.lei
 * @create 2020-03-15 12:07
 */
public class Main {
    public static void main(String[] args) {
//        Thread wd1=new Thread(new TicketRunnable());
//        Thread wd2=new Thread(new TicketRunnable());
//        Thread wd3=new Thread(new TicketRunnable());
        TicketRunnable w=new TicketRunnable();
        Thread wd1=new Thread(w);
        Thread wd2=new Thread(w);
        Thread wd3=new Thread(w);
        wd1.setName("窗口一");
        wd2.setName("窗口二");
        wd3.setName("窗口三");
        wd1.start();
        wd2.start();
        wd3.start();
    }
}
