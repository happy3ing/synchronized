package com.happy3ing.juc.test.reentrant;

/**
 * @Author: Dai Mengmeng
 * @Description: synchronized 可重入验证 情况1:证明同一个方法是可重入的
 * @Date: 2021/4/7 10:07
 */
public class Reentrant1 {

    static int i = 0;
    public static void main(String[] args) {
        reentrant();
    }

    public static synchronized void reentrant(){
        System.out.println("i=" + i);
        if(i == 0){
            i++;
            reentrant();
        }
    }
}
