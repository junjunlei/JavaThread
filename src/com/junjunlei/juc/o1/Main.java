package com.junjunlei.juc.o1;

/**
 * @author junjun.lei
 * @create 2020-03-18 1:50
 */
public class Main {
    public static void main(String[] args) {
        VolatileThread volatileThread=new VolatileThread();
        Thread thread=new Thread(volatileThread);
        thread.start();
        while (true){
            if (volatileThread.isFlag()){
                System.out.println(volatileThread.isFlag());
                System.out.println("结束");
                break;
            }
        }
    }
}
