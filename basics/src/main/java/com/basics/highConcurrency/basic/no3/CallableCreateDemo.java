package com.basics.highConcurrency.basic.no3;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableCreateDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCallable());
        Thread thread = new Thread(futureTask);
        thread.start();
        ;
        for (int i = 0; i < 10; i++) {
        }
        System.out.println(futureTask.get());

    }
}
