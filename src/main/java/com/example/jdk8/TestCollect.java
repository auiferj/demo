package com.example.jdk8;

import java.util.*;
import java.util.stream.Collectors;

public class TestCollect {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        Integer integer = max.get();
        System.out.println(integer);

        Optional<Integer> max1 = list.stream().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)));
        Integer integer1 = max1.get();
        System.out.println(integer1);

        Double collect = list.stream().collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(collect);

        Map<Boolean, List<Integer>> collect1 = list.stream().collect(Collectors.partitioningBy(i -> i > 3));
        collect1.forEach((k,v) ->{
            System.out.println(k + ":" +v);
        });

        List<String> strList = new ArrayList<>();
        Iterator<String> iterator = strList.iterator();
    }
}
