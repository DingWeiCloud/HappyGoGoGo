package com.basics.highConcurrency.basic.no2;

import java.util.Date;

public class RunnableCreateDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunable());
        thread.run();
        for (int i = 0; i < 10; i++) {
            System.out.println("RunnableCreateDemo 开始执行 " + new Date().getTime());
        }
    }
}
