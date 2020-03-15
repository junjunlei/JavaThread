package com.junjunlei.base.o2;

/**
 * 创建两个分线程，让其中一个线程输出1-100之间的偶数
 * 一个线程输出1-100之间的奇数
 * @author junjun.lei
 * @create 2020-03-14 20:16
 */
public class Main {
    public static void main(String[] args) {
        EvenThread mt=new EvenThread();
        mt.setName("偶数线程");
        OddThread ot=new OddThread();
        ot.setName("奇数线程");
        mt.start();
        ot.start();

        //方式二 创建Thread的匿名内部类
        new Thread(){
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-1");
                int num=100;
                for(int i=0;i<num;i++){
                    if(i%2==0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                Thread.currentThread().setName("Thread-0");
                int num=100;
                for(int i=0;i<num;i++){
                    if(i%2!=0){
                        System.out.println(Thread.currentThread().getName()+":"+i);
                    }
                }
            }
        }.start();
    }
}
