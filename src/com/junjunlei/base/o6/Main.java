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
 *
 * 解决方式一： 同步代码块
 *      synchronized(同步监视器){
 *          //待同步代码块
 *      }
 *   说明：  1.操作共享数据的代码，即需要被同步的代码
 *          2.共享数据：多个线程共享操作的变量 比如：ticket 就是共享数据
 *          3.同步监视器，俗称：锁 任何一个类的对象 都可以充当锁
 *                要求：多个线程必须共用同一把锁
 * 解决方式二：  同步方法
 * 关于同步方法：
 *  1.同步方法仍然涉及到同步监视器，只是不需要我们显示声明
 *  2.非静态的同步方法，同步监视器是this
 *    静态同步方法，同步监视器是：当前类本身
 *
 * 同步的方式，解决了线程安全问题
 *     但是，操作同步代码块时，只能有一个线程参与，其他线程等待，相当于单线程，效率低
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
