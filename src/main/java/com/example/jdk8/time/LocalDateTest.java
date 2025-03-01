package com.example.jdk8.time;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LocalDateTest {
    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        LocalDate lastDay = now.with(TemporalAdjusters.lastDayOfMonth());
        int dayOfMonth = lastDay.getDayOfMonth();
        System.out.println("本月最后一天" + dayOfMonth);
        List<Integer> result = IntStream.rangeClosed(1, dayOfMonth).mapToObj(i -> i).collect(Collectors.toList());
        List<Integer> res = IntStream.rangeClosed(1, dayOfMonth).boxed().collect(Collectors.toList());
        System.out.println(result);
        boolean equals = Objects.equals(1, 2);
        if(null == null){
            System.out.printf("kk");
        }
    }
}
