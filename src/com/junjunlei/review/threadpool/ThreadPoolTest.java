package com.junjunlei.review.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池工具类 Executors（阿里巴巴开发手册不建议使用） 艾克赛克油特
 *
 * @author junjun.lei
 * @create 2020-06-03 0:30
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
        //固定数线程池,类似银行n个窗口办理业务
        //ExecutorService threadPool = Executors.newFixedThreadPool(5);

        //一池一个工作线程，类似一个银行有一个受理窗口
        //ExecutorService threadPool = Executors.newSingleThreadExecutor();

        //根据需要创建新线程
        ExecutorService threadPool = Executors.newCachedThreadPool();

        /**
         * Executors工具类底层还是使用的 new ThreadPoolExecutor()创建的线程
         *    1.newFixedThreadPool 方法 corePoolSize和 maximumPoolSize设置的相同，也就是传入的固定参数，
         *    队列使用的
         *    LinkedBlockingQueue，所以允许请求的队列最大长度为Integer.MAX_VALUE，可能会堆积大量请求
         *    导致OOM
         *
         *    2.newSingleThreadExecutor 方法 corePoolSize和 maximumPoolSize为1，队列使用的
         *    LinkedBlockingQueue，所以允许请求的队列最大长度为Integer.MAX_VALUE，可能会堆积大量请求
         *    导致OOM
         *
         *    3.newCachedThreadPool 方法corePoolSize为0 和corePoolSize为Integer.MAX_VALUE,也就是说
         *    会创建大量线程，导致OOM 阻塞队列为SynchronousQueue
         *
         */

        try {
            for (int i = 1; i <= 10; i++) {
                //模拟有10个顾客到银行办理业务，目前池子里面有5个工作人员提供服务
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t 办理业务");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //池化技术，一定要关闭
            threadPool.shutdown();
        }

    }
}