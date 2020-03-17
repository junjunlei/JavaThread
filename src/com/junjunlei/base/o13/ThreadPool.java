package com.junjunlei.base.o13;

import com.junjunlei.base.o12.CallableThread;
import com.junjunlei.base.o2.EvenThread;

import java.util.concurrent.*;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
 * 1.提高响应速度（减少了创建新线程的时间）
 * 2.降低资源消耗（重复利用线程池中线程，不需要每次都创建）
 * 3.便于线程管理
 *      corePoolSize：核心池的大小
 *      maximumPoolSize：最大线程数
 *      keepAliveTime：线程没有任务时最多保持多长时间后会终止
 * @author junjun.lei
 * @create 2020-03-18 0:08
 */
public class ThreadPool {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //Executors.newCachedThreadPool(EvenThread);
        ExecutorService service=Executors.newFixedThreadPool(10);
        ThreadPoolExecutor threadPoolExecutor= (ThreadPoolExecutor) service;
        //设置线程池属性
        ((ThreadPoolExecutor) service).setCorePoolSize(15);
        //((ThreadPoolExecutor) service).setKeepAliveTime();
        service.execute(new EvenThread());
        //execute适用于Runnable
        service.execute(new EvenThread());
        //submit 适用于Callable
        Future submit = service.submit(new CallableThread());
        System.out.println(submit.get());
        service.shutdown();
    }
}
