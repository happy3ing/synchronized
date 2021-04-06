package com.happy3ing.juc;

/**
 * @Author: Dai Mengmeng
 * @Description: synchronized 对象锁--代码块形式
 * @Date: 2021/4/6 11:01
 */
public class SynchronizedMethodTest1 implements Runnable{

    static SynchronizedMethodTest1 instance = new SynchronizedMethodTest1();
    Object lock1 = new Object();
    Object lock2 = new Object();

    public void run() {
        synchronized (lock1) {
            System.out.println("我是线程" + Thread.currentThread().getName() + ", 我开始运行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程" + Thread.currentThread().getName() + ",我结束了");
        }

        synchronized (lock2) {
            System.out.println("我是测试线程" + Thread.currentThread().getName() + ", 我开始运行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是测试线程" + Thread.currentThread().getName() + ",我结束了");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("测试开始+++++++++++++++++++++++++++++++++++++++");
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("测试结束+++++++++++++++++++++++++++++++++++++++");
    }
}
