package com.junjunlei.base.o9;

/**
 * 银行有一个账户，有两个储户分别向同一个账户存3000元，
 * 每次存1000元，存三次，每次存完打印账户余额
 *
 *  分析：
 *     1，是否有多线程问题？ 是 ，两个储户线程
 *     2.是否有共享数据 ？ 有 账户
 *     3，是否有线程安全问题？ 有
 *     4.需要考虑如何解决线程安全问题？ 同步机制：三种方式
 * @author junjun.lei
 * @create 2020-03-15 17:55
 */
public class BankThread {
    public static void main(String[] args) {
        Account account=new Account(0);
        Customer customer1 =new Customer(account);
        Customer customer2 =new Customer(account);
        customer1.setName("储户1");
        customer2.setName("储户2");
        customer1.start();
        customer2.start();
    }
}
