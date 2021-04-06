package com.happy3ing.juc.test;

/**
 * @Author: Dai Mengmeng
 * @Description:  两个线程同时访问一个对象的同步方法；锁生效
 * @Date: 2021/4/6 15:34
 */
public class Test1 implements Runnable{

    static Test1 test1 = new Test1();

    public synchronized void run() {
        System.out.println(Thread.currentThread().getName() + "运行开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "运行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(test1);
        Thread thread1 = new Thread(test1);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
