package com.junjunlei.base.o5;
/**
 * @author junjun.lei
 * @create 2020-03-15 12:01
 */
public class Main {
    public static void main(String[] args) {
        Thread th=new Thread(new RunnableThread());
        th.start();
    }
}
