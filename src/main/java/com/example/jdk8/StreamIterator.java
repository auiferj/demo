package com.example.jdk8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamIterator {
    public static void main(String[] args) {
        //List<Integer> list = Stream.iterate(0, n -> n + 2).limit(5).collect(Collectors.toList());
        //list.forEach(i -> System.out.println(i));

        //List<Integer> monthList = Stream.iterate(1,n -> n+1).limit(12).collect(Collectors.toList());
        //monthList.forEach(i -> System.out.println(i));

        // List<String> randomList = Stream.generate(() -> UUID.randomUUID().toString()).limit(10).collect(Collectors.toList());
        // randomList.forEach(i -> System.out.println(i));
        //
        // IntStream stream = Arrays.stream(new int[]{1, 2, 3});
        // Stream<Integer> boxed = stream.boxed();
        // List<Integer> collect = boxed.collect(Collectors.toList());

        // List<Integer> oneList = new ArrayList<>(Arrays.asList(1, 2));
        // List<Integer> twoList = new ArrayList<>(Arrays.asList(3, 4));
        // List<Integer> together = Stream.
        //         of(oneList,twoList)
        //         .flatMap(numbers -> numbers.stream())
        //         .map(i -> i + 2)
        //         .collect(Collectors.toList());
        // together.forEach(i -> System.out.println(i));
        //
        // ExecutorService executorService = Executors.newFixedThreadPool(10);
        // executorService.execute(() -> System.out.println("000"));

        List<String> list = new ArrayList<String>(Arrays.asList("1,2,3","4,5,6"));
        List<String> collect = list.stream().flatMap(i -> {
            String[] arr = i.split(",");
            Stream<String> stream = Arrays.stream(arr);
            return stream;
        }).collect(Collectors.toList());
        collect.forEach(i -> System.out.println(i));

    }
}
