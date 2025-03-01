package com.example.filestream;

import java.util.regex.Pattern;

public class SampleCrawler {
    private static final Pattern IMAGE_EXTENSIONS = Pattern.compile(".*\\.(bmp|gif|jpg|png)$");

    public static void main(String[] args) {
        String href = "king.png";
        if (IMAGE_EXTENSIONS.matcher(href).matches()) {
            System.out.println("是图片");
        }else{
            System.out.println("不是图片");
        }
    }
}
