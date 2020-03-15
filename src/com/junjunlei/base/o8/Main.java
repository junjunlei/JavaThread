package com.junjunlei.base.o8;

/**
 * @author junjun.lei
 * @create 2020-03-15 17:37
 */
public class Main {
    public static void main(String[] args) {
        LockThread lt=new LockThread();
        Thread th1=new Thread(lt);
        Thread th2=new Thread(lt);
        Thread th3=new Thread(lt);
        th1.setName("窗口一");
        th2.setName("窗口二");
        th3.setName("窗口三");
        th1.start();
        th2.start();
        th3.start();
    }
}
