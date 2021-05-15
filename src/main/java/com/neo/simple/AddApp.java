package com.neo.simple;

import java.util.concurrent.*;

/**
 * 十个线程顺序打印1~10
 */
public class AddApp {

    private static volatile int number = 1;
    private static volatile int max = 1000;

    //    private static int pos = 1;
    //线程数
    private static int threadNum = 10;

    private static Object lock = new Object();

    public static void run(int i) {
        int pos = i;
        synchronized (lock) {

            while (number < max) {
                //应该打印的线程
                int print = number % threadNum;
                print = print == 0 ? threadNum : print;
                if (print != pos) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("Thread-Id" + Thread.currentThread().getId() + "----" + number);
                    number++;
                    lock.notifyAll();
                }
            }
        }
    }


    public static void main(String[] args) {

        for (int i = 1; i <= threadNum; i++) {
            int j = i;
            Thread a = new Thread(() -> {
                run(j);
            });
            a.start();
        }
    }

}
