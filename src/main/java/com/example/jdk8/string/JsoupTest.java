package com.example.jdk8.string;

import org.jsoup.Jsoup;

public class JsoupTest {
    public static void main(String[] args) {
        String example = null;
        String text = Jsoup.parse(example).text();
        System.out.println("text"+text);
    }
}
