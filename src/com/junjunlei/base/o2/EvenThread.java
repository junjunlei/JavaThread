package com.junjunlei.base.o2;

/**
 * 输出100以内的偶数
 * @author junjun.lei
 * @create 2020-03-14 20:13
 */
public class EvenThread extends Thread {
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
