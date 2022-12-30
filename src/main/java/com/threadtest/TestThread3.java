package com.threadtest;

// 实现runnable接口，重写run方法
public class TestThread3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程---"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        TestThread3 testThread3 = new TestThread3();
        //创建线程对象，通过线程对象来开启我们的线程代理
//        Thread thread = new Thread(testThread3);
//        thread.start();
        new Thread(testThread3).start();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程---"+i);
        }
    }
}
