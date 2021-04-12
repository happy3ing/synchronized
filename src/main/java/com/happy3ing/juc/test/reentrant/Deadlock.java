package com.happy3ing.juc.test.reentrant;

/**
 * @Author: Dai Mengmeng
 * @Description: 死锁
 * @Date: 2021/4/7 13:42
 */
public class Deadlock implements Runnable{

    static Deadlock deadlock = new Deadlock();
    static Deadlock deadlock1 = new Deadlock();

    public void run() {
        synchronized (deadlock){
            System.out.println(Thread.currentThread().getName() + "方法test1--deadlock");
            synchronized (deadlock1){
                System.out.println(Thread.currentThread().getName() + "方法test1--deadlock1");
            }
        }
        synchronized (deadlock1){
            System.out.println(Thread.currentThread().getName() + "方法test2--deadlock1");

            synchronized (deadlock){
                System.out.println(Thread.currentThread().getName() + "方法test2--deadlock");
            }
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(deadlock);
        Thread thread1 = new Thread(deadlock1);
        thread.start();
        thread1.start();
        while (thread.isAlive() || thread1.isAlive()){

        }
        System.out.println("执行结束");
    }
}
