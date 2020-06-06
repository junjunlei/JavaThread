package com.junjunlei.review.referencetype;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * 软引用
 *
 *   有用非必需的对象，软引用关联的对象，在系统发生内存溢出异常之前（也就是内存不够的时候），
 *   将会把这些对象列为回收范围之中就行二次回收   SoftReference类实现软引用
 *
 *
 *    软引用适合做缓存
 * @author junjun.lei
 * @create 2020-06-04 15:59
 */
public class T02_SoftReference {
    /**
     * 设置堆内存大小 -Xmx20M
     * @param args
     */
    public static void main(String[] args) {
        //sr 和 new byte[1024*1024*10]之间的引用就是弱引用
        SoftReference<byte[]> sr=new SoftReference<>(new byte[1024*1024*10]);
        //垃圾回收之前
        System.out.println(sr.get());
        System.gc();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //垃圾回收之后，依然可以取到
        System.out.println(sr.get());

        //这里分配了11m 而之前10m 加起来就大于20m,这时候软引用会被回收（这里gc了）
        byte[] b=new byte[1024*1024*11];

        System.out.println(sr.get());
    }
}
