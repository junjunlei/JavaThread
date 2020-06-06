package com.junjunlei.review.referencetype;

import java.io.IOException;

/**
 * 强引用
 *    就是在代码中普遍存在的，类似“Object obj=new Object();”
 *    这类的引用
 *
 *    只要强引用还在，垃圾回收器永远不会回收调被引用的对象
 * @author junjun.lei
 * @create 2020-06-04 15:53
 */
public class T01_StrongReference {
    public static void main(String[] args) throws IOException {
        M m=new M();
        //代表会被回收，调用finlize()方法
        m=null;
        System.gc();
        //回收实在gc线程，防止主线程a结束
        System.in.read();
    }
}
