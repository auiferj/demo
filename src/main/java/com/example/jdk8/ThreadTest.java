package com.example.jdk8;

public class ThreadTest {
    public static void main(String[] args) {
        System.out.println("888");
        new Thread(){
            public void  run(){
                System.out.println("999");
            }
        }.start();
    }
}
