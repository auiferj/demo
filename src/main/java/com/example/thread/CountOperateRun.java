package com.example.thread;

public class CountOperateRun {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        new Thread(countOperate).start();
    }
}
