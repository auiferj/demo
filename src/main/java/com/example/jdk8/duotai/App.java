package com.example.jdk8.duotai;

import lombok.val;

public class App {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.speak();
        Animal dog = new Dog();
        dog.speak();
        //cat.run()
    }

}
