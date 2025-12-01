package com.example.thread;

public class CountOperateRun1 {
    public static void main(String[] args) {
        CountOperate countOperate = new CountOperate();
        new Thread(countOperate).start();
    }
}
