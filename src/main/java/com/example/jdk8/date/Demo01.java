package com.example.jdk8.date;

import java.time.LocalDate;
import java.time.YearMonth;

public class Demo01 {
    public static void main(String[] args) {
        /**
         * ava 8 中的 LocalDate 用于表示当天日期。和java.util.Date不同，它只有日期，不包含时间。当你仅需要表示日期时就用这个类。
         */
        LocalDate today = LocalDate.now();
        System.out.println("今天的日期:"+today);

        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();

        System.out.println("year:"+year);
        System.out.println("month:"+String.format("%02d", month));
        System.out.println("day:"+day);

        LocalDate date = LocalDate.of(2018,1,6);
        System.out.println("自定义日期:"+date);

        int lengthOfMonth = YearMonth.of(2023, 4).lengthOfMonth();
        int endDay = 31;
        if(endDay > lengthOfMonth){
            endDay = lengthOfMonth;
        }
        LocalDate of = LocalDate.of(2023, 4, endDay);
        System.out.println("测试不存在的日期：" + of);
    }
}
