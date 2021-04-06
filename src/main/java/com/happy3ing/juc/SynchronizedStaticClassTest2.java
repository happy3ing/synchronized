package com.happy3ing.juc;

/**
 * @Author: Dai Mengmeng
 * @Description: synchronized 类锁--.class锁形式
 * @Date: 2021/4/6 11:01
 */
public class SynchronizedStaticClassTest2 implements Runnable{

    static SynchronizedStaticClassTest2 instance = new SynchronizedStaticClassTest2();
    static SynchronizedStaticClassTest2 instance1 = new SynchronizedStaticClassTest2();

    public void run() {
        synchronizedMethod();
    }

    private void synchronizedMethod() {
        synchronized (SynchronizedStaticClassTest2.class) {
            System.out.println("我是线程" + Thread.currentThread().getName() + ", 我开始运行了");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是线程" + Thread.currentThread().getName() + ",我结束了");
        }
    }

    public static void main(String[] args) {
        System.out.println("测试开始+++++++++++++++++++++++++++++++++++++++");
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance1);
        thread1.start();
        thread2.start();
        while (thread1.isAlive() || thread2.isAlive()){

        }
        System.out.println("测试结束+++++++++++++++++++++++++++++++++++++++");
    }
}
