package com.basics.highConcurrency.basic.no1;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println("MyThread 正在执行 " + i);
        }
    }
}
