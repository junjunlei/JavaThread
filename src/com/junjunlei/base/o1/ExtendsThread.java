package com.junjunlei.base.o1;

/**
 * 创建多线程的方式一 ： extends Thread
 * <p>
 * 1.定义子类继承Thread类
 * 2.字类重写Thread类中的run方法
 * 3.创建字类对象
 * 4.调用线程对象的start方法：启动线程，调用run方法
 * <p>
 * 例子：遍历100以内的偶数
 *
 * @author junjun.lei
 * @create 2020-03-14 19:19
 */
public class ExtendsThread extends Thread {
    /**
     * 重写run方法
     */
    @Override
    public void run() {
        int num = 100;
        for (int i = 0; i < num; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
