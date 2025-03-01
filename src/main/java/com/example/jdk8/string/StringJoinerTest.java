package com.example.jdk8.string;

import java.util.StringJoiner;

public class StringJoinerTest {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");
        System.out.printf("999"+stringJoiner.toString());
    }
}
