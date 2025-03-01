package com.example.jdk8.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Tgh {
    public static void main(String[] args) {
        // int[] ints = {1, 2, 3};
        // int[] ints1 = new int[3];
        // ints1[0] = 1;
        // ints1[1] = 2;
        // ints1[2] = 3;
        // Integer[] ints2 = new Integer[3];
        // IntStream stream = Arrays.stream(ints1);
        // stream.forEach(x -> System.out.println(x));
        // List<Integer> integers = Arrays.asList(ints2);
        // //integers.add(4);
        // List<Integer> integers1 = new ArrayList<>(integers);
        // integers1.add(4);
        // for (Integer integer : integers1) {
        //     System.out.println(integer);
        // }

        // WeekFields weekFields = WeekFields.of(DayOfWeek.of(1),4);
        // int weekNumber = LocalDate.now().get(weekFields.weekOfWeekBasedYear());
        // System.out.println(weekNumber);
        //
        // LocalDate localDate = LocalDate.of(2020,12,31);
        // int weekNumber2 = localDate.get(weekFields.weekOfWeekBasedYear());
        // System.out.println(weekNumber2);
        //
        // LocalDate localDate3 = LocalDate.of(2021,1,1);
        // int weekNumber3 = localDate3.get(weekFields.weekOfWeekBasedYear());
        // System.out.println(weekNumber3);

        Stream.of(1,1,1).min(Comparator.comparing(Integer::intValue)).ifPresent(u -> System.out.println(u));
    }
}
