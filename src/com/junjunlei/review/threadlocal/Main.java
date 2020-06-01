package com.junjunlei.review.threadlocal;

/**
 * @author junjun.lei
 * @create 2020-05-20 14:40
 */
public class Main {
    public static void main(String[] args) {
        new Thread(()->{
            try {
                for(int i=0;i<100;i++){
                    Tools.threadLocal.set("ThreadA"+(i+1));
                    System.out.println("ThreadA get value"+Tools.threadLocal.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadA").start();

        new Thread(()->{
            try {
                for(int i=0;i<100;i++){
                    Tools.threadLocal.set("ThreadB"+(i+1));
                    System.out.println("ThreadB get value"+Tools.threadLocal.get());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"ThreadB").start();
    }
}
