package com.threadtest;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 extends Thread {
    private String url; //图片地址
    private String name; //保存文件名

    public TestThread2(String url,String name){
        this.url = url;
        this.name = name;
    }

    //下载图片线程的执行体
    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url,name);
        System.out.println("下载了文件名为:"+name);
    }

    // 主函数
    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://img2.baidu.com/it/u=1818947641,1834585525&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=503", "人物1.jpg");
        TestThread2 t2 = new TestThread2("https://img2.baidu.com/it/u=1818947641,1834585525&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=503", "人物2.jpg");
        TestThread2 t3 = new TestThread2("https://img2.baidu.com/it/u=1818947641,1834585525&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=503", "人物3.jpg");
        //并行下载
        t1.start();
        t2.start();
        t3.start();
    }
}

class WebDownloader {
    //下载方法
    public void downloader(String url,String name){
        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO异常,downloader方法");
        }
    }
}
