package com.junjunlei.review.lambda;

/**
 * lambda表达式
 *
 *  接口必须为功能性接口（函数式接口）
 *  且只有一个抽象方法（default修饰的 和 static修饰的不是抽象方法）
 * @author junjun.lei
 * @create 2020-06-01 13:39
 */
@FunctionalInterface
public interface LambdaInterface {

    void say(String message);

    default String self() {
        return "接口里面的实现方法";
    }

    default String self1() {
        return "接口里面的实现方法1";
    }
    static String  staticMethod(){
        return "接口里面的静态方法";
    };
}
