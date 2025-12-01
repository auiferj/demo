package com.example.thread;

public class Run {
    public static void main(String[] args) {
        new MyThread().start();
        System.out.println("结束运行");
    }
}
