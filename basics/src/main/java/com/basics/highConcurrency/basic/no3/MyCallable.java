package com.basics.highConcurrency.basic.no3;

import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println("MyCallable 正在执行 " + i);
        }
        return "MyCallable 执行完毕";
    }
}
