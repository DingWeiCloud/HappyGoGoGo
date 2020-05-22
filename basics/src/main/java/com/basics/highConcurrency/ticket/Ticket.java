package com.basics.highConcurrency.ticket;

public class Ticket implements Runnable {
    private int total = 10;
    //定义票的编号
    private int no = total + 1;
    //定义一个线程同步对象
    private Object obj = new Object();

    @Override
    public void run() {

        while (true) {
            //同步锁
            synchronized (this.obj) {
                if (this.total > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String msg = Thread.currentThread().getName() + " 售出第   " + (this.no - this.total) + "  张票";
                    System.out.println(msg);
                    this.total--;
                } else {
                    System.err.println("票已售完，请下次再来！");
                    System.exit(0);
                }
            }
        }
    }
}

