package com.example.jdk8.string;

import org.apache.commons.lang3.StringUtils;

public class StringUtilsTest {
    public static void main(String[] args) {
        String code = "abcd_dd";
        String s = StringUtils.substringAfterLast(code, "_");
        System.out.println("s = " + s);
    }
}
