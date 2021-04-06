package com.happy3ing.juc.test;

/**
 * @Author: Dai Mengmeng
 * @Description: 访问同一个对象的不同的普通同步方法； 锁生效
 * @Date: 2021/4/6 15:34
 */
public class Test5 implements Runnable{

    static Test5 test1 = new Test5();
    static Test5 test2 = new Test5();

    public void run() {
        if("Thread-0".equals(Thread.currentThread().getName())){

            staticMethod();
        }else {
            normalMethod();
        }
    }

    private static synchronized void staticMethod() {
        System.out.println(Thread.currentThread().getName() + "同步方法运行开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "同步方法运行结束");
    }

    private static synchronized void normalMethod() {
        System.out.println(Thread.currentThread().getName() + "非同步方法运行开始");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "非同步方法运行结束");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(test1);
        Thread thread1 = new Thread(test2);
        thread.start();
        thread1.start();
        thread.join();
        thread1.join();
    }
}
