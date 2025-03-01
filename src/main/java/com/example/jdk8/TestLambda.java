package com.example.jdk8;

import java.util.HashMap;
import java.util.Map;

public class TestLambda {
    public static void main(String[] args) {
        useHashMap(new HashMap<>());
        System.out.println("Hello World!");
    }

    public static void useHashMap(Map<String,String> values){
        System.out.println("values");
    }
}
