package com.junjunlei.base.o5;

/**
 * 创建多线程的方式二：
 * 实现runnable接口
 *
 * 1) 定义子类，实现Runnable接口。
 * 2) 子类中重写Runnable接口中的run方法。
 * 3) 通过Thread类含参构造器创建线程对象。
 * 4) 将Runnable接口的子类对象作为实际参数传递给Thread类的构造器中。
 * 5) 调用Thread类的start方法：开启线程，调用Runnable子类接口的start方法。
 *
 *  比较创建线程的两种方式。
 *      开发中：优先选择：实现Runnable接口的方式
 *      原因：1. 实现的方式没有类的单继承性的局限性
 *           2. 实现的方式更适合来处理多个线程有共享数据的情况。
 * @author junjun.lei
 * @create 2020-03-15 11:59
 */
public class RunnableThread implements Runnable {
    /**
     * 100以内偶数
     */
    @Override
    public void run() {
        int num=100;
        for(int i=0;i<num;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}
