package com.basics.highConcurrency.basic.no2;

import java.util.Date;

public class MyRunable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println("MyRunable 正在执行" + new Date().getTime());
        }
    }
}
