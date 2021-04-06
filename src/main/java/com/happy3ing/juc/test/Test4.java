package com.happy3ing.juc.test;

/**
 * @Author: Dai Mengmeng
 * @Description: 同时访问同步方法与非同步方法； 锁不生效
 * @Date: 2021/4/6 15:34
 */
public class Test4 implements Runnable{

    static Test4 test1 = new Test4();
    static Test4 test2 = new Test4();

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

    private void normalMethod() {
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
