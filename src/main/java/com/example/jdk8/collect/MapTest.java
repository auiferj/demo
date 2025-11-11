package com.example.jdk8.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MapTest {
    public static void main(String[] args) {
        Map<Object, Object> hashMap = new ConcurrentHashMap<>();
        Object id = hashMap.putIfAbsent("id", 1);
        System.out.println("id = " + id);
        Object id2 = hashMap.putIfAbsent("id", 2);
        System.out.println("id2 = " + id2);

        Map<String, String> hMap = new HashMap<>();
    }
}
