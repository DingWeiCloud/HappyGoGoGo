package com.basics.highConcurrency.basic.no4;

public class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyRunable 正在执行" + i);
        }
    }
}
