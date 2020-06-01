package com.junjunlei.review.threadlocal;

import java.util.Date;

/**
 *  threadLocal 学习
 * @author junjun.lei
 * @create 2020-05-20 14:38
 */
public class Tools {
    public static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public  static ThreadLocal<Date> threadLocal1 = new ThreadLocal<>();

    public static void main(String[] args) {
        threadLocal1.get().getTime();
    }
}
