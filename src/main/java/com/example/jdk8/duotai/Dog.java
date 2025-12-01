package com.example.jdk8.duotai;

public class Dog implements Animal {

    @Override
    public void speak() {
        System.out.printf("wangwangwang");
    }

    public void run(){
        System.out.println("little");
    }
}
