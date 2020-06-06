package com.junjunlei.review.referencetype;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.ref.WeakReference;
import java.sql.SQLOutput;

/**
 * 弱引用
 *     也是用来描述非必需对象，但是强度比软引用低
 *     遇到gc就会被回收 （而软引用是内存不够才会被回收）
 *
 *     通过WeakReference类来实现弱引用
 *
 *
 *     ThreadLocal是通过弱引用来实现的，这是面试重点
 * @author junjun.lei
 * @create 2020-06-04 16:18
 */
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m=new WeakReference<>(new M());

        //gc之前
        System.out.println(m.get());
        System.gc();
        //gc之后就不存在了，而且执行了finalize方法，说明被回收了
        System.out.println(m.get());


        /**
         * 使用完ThreadLocal最好手动remove()无用的Entry防止内存泄漏，并且定义ThreadLocal时建议
         * 将他定义为static延长生命周期
         */
        ThreadLocal<M> tl=new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
