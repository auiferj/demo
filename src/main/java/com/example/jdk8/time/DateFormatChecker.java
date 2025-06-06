package com.example.jdk8.time;

import org.apache.commons.lang3.time.DateUtils;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Arrays;
import java.util.Date;

public class DateFormatChecker {
    public static boolean isValidDateFormat(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.M.d");
        try {
            LocalDate.parse(dateString, formatter);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    public static void main(String[] args) throws ParseException {
        String string1 = "2023.10.26";
        String string2 = "2024.2.8";
        String string3 = "2023-10-26";
        String string4 = "2023.10.2";
        String string5 = "invalid date";
        String string6 = "2025.4.16"; // 符合当前日期
        String string7 = "2025.04.16"; // 符合当前日期

        System.out.println(String.format("'%s' 是否符合格式: %s", string1, isValidDateFormat(string1)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string2, isValidDateFormat(string2)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string3, isValidDateFormat(string3)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string4, isValidDateFormat(string4)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string5, isValidDateFormat(string5)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string6, isValidDateFormat(string6)));
        System.out.println(String.format("'%s' 是否符合格式: %s", string7, isValidDateFormat(string7)));
        Date date = DateUtils.parseDate(string7, new String[]{"yyyy.M.d"});
        System.out.println("date = " + date);
    }
}
