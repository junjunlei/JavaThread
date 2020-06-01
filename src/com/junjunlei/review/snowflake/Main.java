package com.junjunlei.review.snowflake;
/**
 * @author junjun.lei
 * @create 2020-05-20 17:28
 */
public class Main {
    public static void main(String[] args) {
        IdWorker idWorker=new IdWorker();
        long nextId = idWorker.nextId();
        System.out.println(nextId);
    }
}
