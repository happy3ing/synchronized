package com.happy3ing.juc;

/**
 * @Author: Dai Mengmeng
 * @Description:
 * @Date: 2021/4/6 10:28
 */
public class ThreadTest1 implements Runnable{

    static ThreadTest1 thread;
    static int i = 0;

    static {
        try {
            thread = ThreadTest1.class.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(thread);
        Thread thread2 = new Thread(thread);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }

    public void run() {
        for(int j = 0; j < 100000; j++){
            i++;
        }
    }
}
