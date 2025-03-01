package com.example.jdk8;

import java.util.stream.Stream;

public class JdkTest {
    public static void main(String[] args) {
        //求和
        Integer sumReduce = Stream.of(1, 2, 3).reduce(0, (acc, element) -> acc + element);
        System.out.println(sumReduce);
        //求最大值
        Integer maxReduce = Stream.of(1, 2, 3).reduce(1, (acc, element) -> {
            int i = acc - element;
            if (i > 0) {
                return acc;
            } else {
                return element;
            }
        });
        System.out.println(maxReduce);
        //求最小值
        Integer minReduce = Stream.of(1, 2, 3).reduce(1, (acc, element) -> {
            int i = acc - element;
            if (i > 0) {
                return element;
            } else {
                return acc;
            }
        });
        System.out.println(minReduce);
        //求数量
        Integer countReduce = Stream.of(1, 2, 3).reduce(0, (acc, element) -> {
            int i = acc+1;
            return i;
        });
        System.out.println(countReduce);
    }
}
