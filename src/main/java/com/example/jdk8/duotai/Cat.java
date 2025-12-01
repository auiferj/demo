package com.example.jdk8.duotai;

public class Cat implements Animal{
    @Override
    public void speak() {
        System.out.println("miaomiaomiao");
    }

    public void run(){
        System.out.println("silent");
    }
}
