package com.happy3ing.juc.test.reentrant;

/**
 * @Author: Dai Mengmeng
 * @Description: synchronized 可重入验证 情况3:证明可重入不要求是同一类中的
 * @Date: 2021/4/7 10:07
 */
public class Reentrant3 {

    public synchronized void reentrant(){
        System.out.println("父类方法");
    }

}

class Reentrant4 extends Reentrant3{

    @Override
    public synchronized void reentrant(){
        System.out.println("子类方法");
        super.reentrant();
    }

    public static void main(String[] args) {
        Reentrant4 reentrant4 = new Reentrant4();
        reentrant4.reentrant();
    }
}
