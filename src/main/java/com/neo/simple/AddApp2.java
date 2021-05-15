package com.neo.simple;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class AddApp2 {

    private static int number = 0;

    private static final Semaphore semaphore = new Semaphore(1);

//    private static CountDownLatch countDownLatch = new CountDownLatch(1000);
    private static CyclicBarrier barrier = new CyclicBarrier(1000);

    public static void main(String[] args) {
//        Thread[] threads = new Thread[10];

//        ExecutorService executorService = Executors.newFixedThreadPool(1000);

        for (int i = 0; i < 1000; i++) {
//            executorService.submit(() -> {
        Thread temp = new Thread(()->{
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
//                semaphore.tryAcquire(1);
                int num = number;
            num = num + 1;
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            number = num;

            System.out.println(Thread.currentThread().getId()+ "-----" +number);
//                semaphore.release();
            });
        temp.start();
        }
//        System.out.println(number);
//        executorService.shutdown();
    }
}
