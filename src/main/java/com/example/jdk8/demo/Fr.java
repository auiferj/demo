package com.example.jdk8.demo;

import java.text.NumberFormat;

public class Fr {
    public static void main(String[] args) {
        Double rate =0.03;
        NumberFormat num = NumberFormat.getPercentInstance();
        String rates = num.format(rate);
        System.out.println(rates);
    }
}
