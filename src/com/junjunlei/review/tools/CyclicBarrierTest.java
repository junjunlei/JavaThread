package com.junjunlei.review.tools;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 加法计数器
 *
 * CyclicBarrier  塞克雷克
 *
 *  屏障 === 所有人到达一个点后，一起跨过去
 * @author junjun.lei
 * @create 2020-06-01 22:37
 */
public class CyclicBarrierTest {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(7,()->{
            System.out.println("集齐七龙珠");
        });

        for(int i=1;i<=7;i++){
            final int temp=i;
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"收集到第"+temp+"颗龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
