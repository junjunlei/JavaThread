package com.junjunlei.base.o7;

/**
 * 将单例模式中的 懒汉模式改为线程安全
 *
 * @author junjun.lei
 * @create 2020-03-15 13:57
 */
public class Singleton {
    private Singleton(){}
    private static Singleton instance = null;

    public static Singleton getInstance() {
        //效率低
//        synchronized (Singleton.class) {
//            if (instance == null) {
//                instance = new Singleton();
//            }
//            return instance;
//        }
    //效率高
        if(instance==null){
            synchronized (Singleton.class) {
                if (instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
