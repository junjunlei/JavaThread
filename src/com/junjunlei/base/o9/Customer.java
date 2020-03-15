package com.junjunlei.base.o9;

/**
 * 储户
 * @author junjun.lei
 * @create 2020-03-15 22:53
 */
public class Customer extends Thread {

    private Account account;
    public Customer(Account account){
        this.account=account;
    }
    @Override
    public void run() {
        for(int i=0;i<3;i++){
            account.doposit(1000);
        }
    }
}
