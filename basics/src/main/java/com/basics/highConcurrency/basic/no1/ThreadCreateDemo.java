package com.basics.highConcurrency.basic.no1;

public class ThreadCreateDemo {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int i = 0; i < 10; i++) {
            System.out.println("ThreadCreateDemo 正在执行" + i);
        }
    }
}
