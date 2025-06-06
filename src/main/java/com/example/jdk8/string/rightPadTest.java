package com.example.jdk8.string;

import org.apache.commons.lang3.StringUtils;

public class rightPadTest {
    public static void main(String[] args) {
        String areaCode = "140406010000";
        String baseAreaCode = StringUtils.rightPad(areaCode.substring(0, 6), 12, '0');
        System.out.println("baseAreaCode = " + baseAreaCode);
    }
}
