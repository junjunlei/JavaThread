package com.junjunlei.sync;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

/**
 * Object obj=new Object();
 * 在内存中占多少字节
 * @author junjun.lei
 * @create 2020-04-20 11:27
 */
public class JolDemo {
    public static void main(String[] args) {

        /**
         * 在jvm 默认开启压缩类型指针 -XX:+UseCompressedClassPointers
         * 以及普通对象压缩指针-XX:+UseCompressedOops （ordinary object pointer）
         * markword 8个字节
         * 类型指针（ClassPointers）  4个字节
         * 实例数据    0字节
         * 填充对齐    12不能被8整除  需要4个字节
         * 所以一共 Object对象 16个字节  而o指针占4字节
         *
         * 在没有开启的情况下
         *
         * markword 8个字节
         * 类型指针 8个字节
         * 实例数据  0字节
         * 填充对齐  16能整除8 不需要对齐 0字节
         *
         * 所以还是 Object对象 16个字节  而o指针占8字节
         *
         *
         * 由于UseCompressedClassPointers的开启是依赖于UseCompressedOops的开启，
         * 因此，要使UseCompressedClassPointers起作用，
         * 得先开启UseCompressedOops，
         * 并且开启UseCompressedOops 也默认开启UseCompressedOops，
         * 关闭UseCompressedOops 默认关闭UseCompressedOops。
         *
         */
        Object obj=new Object();
        //获取对象内部信息
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        /**
         * 加锁之后输出内存布局
         * 发现markword 内存出现了变化 所以锁信息是放在markword中的
         */
        synchronized (obj){
            System.out.println(ClassLayout.parseInstance(obj).toPrintable());
        }

        /*
        //获取对象外部信息
        String toPrintable = GraphLayout.parseInstance(obj).toPrintable();

        //获取对象总大小
        long size = GraphLayout.parseInstance(obj).totalSize();

        System.out.println("size:"+size);
         */
    }
}
