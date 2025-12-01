package com.example.thread;

public class CountOperate extends Thread{
    public CountOperate(){
        System.out.println(this.getName());
    }

    @Override
    public void run() {
        System.out.println(this.getName());
        System.out.printf("alive" + this.isAlive());
    }
}
