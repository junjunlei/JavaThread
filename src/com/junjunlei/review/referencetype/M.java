package com.junjunlei.review.referencetype;

/**
 * java强、软、弱、虚 四种引用
 * @author junjun.lei
 * @create 2020-06-04 15:47
 */
public class M {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
