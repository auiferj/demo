package com.example.jdk8.thread.first;

public class Run {
    public static void main(String[] args) {
        PrintString printString = new PrintString();
        new Thread(printString).start();
        System.out.println("我要停止他！ stopThread = " + Thread.currentThread().getName());
        printString.setContinuePrint(false);
    }
}
