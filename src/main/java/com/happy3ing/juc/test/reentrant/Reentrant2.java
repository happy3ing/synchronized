package com.happy3ing.juc.test.reentrant;

/**
 * @Author: Dai Mengmeng
 * @Description: synchronized 可重入验证 情况2:证明可重入不要求是同一个方法
 * @Date: 2021/4/7 10:07
 */
public class Reentrant2 implements Runnable{

    static Reentrant2 reentrant2 = new Reentrant2();
    public static void main(String[] args) {

        Thread thread = new Thread(reentrant2);
        Thread thread1 = new Thread(reentrant2);
        thread.start();
        thread1.start();

    }

    public static synchronized void reentrant(){
        System.out.println(Thread.currentThread().getName() + "方法一");
        reentrant1();
    }

    public static synchronized void reentrant1(){
        System.out.println(Thread.currentThread().getName() + "方法二");
    }

    public void run() {
        reentrant();
    }
}
