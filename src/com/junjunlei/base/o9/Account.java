package com.junjunlei.base.o9;

/**
 * @author junjun.lei
 * @create 2020-03-15 22:47
 */
public class Account {
    /**
     * 余额
     */
    private double balance;

    public Account(double balance){
        this.balance=balance;
    }

    /**
     * 存钱
     * @param amt
     */
    public synchronized  void doposit(double amt){
      if(amt>0){
          balance+=amt;
      }
        System.out.println(Thread.currentThread().getName()+":"+"存钱成功。"+"账户余额为："+balance);
    }

}
