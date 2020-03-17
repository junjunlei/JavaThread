package com.junjunlei.base.o12;

import java.util.concurrent.Callable;

/**
 * 线程的创建方式三 实现Callable接口
 *
 * 如何理解实现Callable接口的方式创建多线程比实现Runnable接口创建多线程方式强大？
 * 1. call()可以有返回值的。
 * 2. call()可以抛出异常，被外面的操作捕获，获取异常的信息
 * 3. Callable是支持泛型的
 *
 * @author junjun.lei
 * @create 2020-03-17 23:41
 */
public class CallableThread implements Callable {
    @Override
    public Object call() throws Exception {
        int sum=0;
        for(int i=0;i<100;i++){
            sum+=i;
        }
        return sum;
    }
}
