package com.junjunlei.base.o12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author junjun.lei
 * @create 2020-03-17 23:47
 */
public class Main {
    public static void main(String[] args) {
        CallableThread callableThread=new CallableThread();
        //将Callable接口类对象作为参数传递到FutureTask类的构造器中，创建FutureTask对象
        FutureTask future=new FutureTask(callableThread);
        new Thread(future).start();
        try {
            //获取Callable的call方法返回值
            Object sum = future.get();
            System.out.println("总和为："+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}
