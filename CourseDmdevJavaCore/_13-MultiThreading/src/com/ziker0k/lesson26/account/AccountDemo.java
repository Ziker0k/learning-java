package com.ziker0k.lesson26.account;

public class AccountDemo {
    public static void main(String[] args) throws InterruptedException {
        Account account1 = new Account(20_000);
        Account account2 = new Account(20_000);

        AccountThread accountThread1 = new AccountThread(account1, account2);
        AccountThread accountThread2 = new AccountThread(account2, account1);

        accountThread1.start();
        accountThread2.start();

        accountThread1.join();
        accountThread2.join();

        System.out.println(account1 + "\n" + account2);
    }
}
