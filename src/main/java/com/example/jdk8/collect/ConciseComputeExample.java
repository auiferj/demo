package com.example.jdk8.collect;

import java.util.HashMap;
import java.util.Map;

public class ConciseComputeExample {
    public static void main(String[] args) {
        Map<String, Integer> counter = new HashMap<>();

        counter.compute("a", (k, v) -> v == null ? 1 : v + 1);
        counter.compute("b", (k, v) -> v == null ? 10 : v * 2);
        counter.compute("a", (k, v) -> v > 5 ? null : v - 1);

        System.out.println(counter); // 输出可能是: {b=20, a=null} (取决于执行顺序)
    }
}
