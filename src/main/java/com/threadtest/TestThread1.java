package com.threadtest;

public class TestThread1 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("线程---"+i);
        }
    }

    public static void main(String[] args) {
        
        //调用线程
        TestThread1 testThread1 = new TestThread1();
        //并行调用
//        testThread1.start();
        //顺序执行
        testThread1.run();

        for (int i = 0; i < 100; i++) {
            System.out.println("主线程---"+i);
        }
    }
}
