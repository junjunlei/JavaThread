package com.junjunlei.base.o1;

/**
 * 继承Thread 方式创建多线程 测试类
 * @author junjun.lei
 * @create 2020-03-14 19:37
 */
public class ExtendsThreadMain {
    public static void main(String[] args) {
        Thread mt=new ExtendsThread();
        mt.start();
    }
}
