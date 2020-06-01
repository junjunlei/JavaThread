package com.junjunlei.sync;

/**
 * 缓存行验证 cacheline
 *
 * @author junjun.lei
 * @create 2020-04-20 15:03
 */
public class CacheLinePadding02 {
    //缓存行补齐
    private static class Padding {
        //56位
        public volatile long p1, p2, p3, p4, p5, p6, p7;
    }

    private static class T extends Padding {
        //加上面的一共64位  T就是一个缓存行的大小
        public volatile long x = 0L;
    }

    public static T[] arr = new T[2];

    static {
        arr[0] = new T();
        arr[1] = new T();
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (long i = 0; i < 100_0000L; i++) {
                arr[0].x = i;
            }
        });

        Thread t2 = new Thread(() -> {
            for (long i = 0; i < 100_0000L; i++) {
                arr[1].x = i;
            }
        });

        final long start = System.currentTimeMillis();

        t1.start();
        t2.start();
        t1.join();
        t2.join();
        final long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
