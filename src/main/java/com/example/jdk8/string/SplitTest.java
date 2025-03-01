package com.example.jdk8.string;

import org.springframework.util.SimpleIdGenerator;

import java.util.UUID;

/**
 * @author lenovo
 */
public class SplitTest {
    public static void main(String[] args) {
        String t = "/file_upload/shebao/2020-03-01/ec8ab0f6-2c27-4023-a790-a8f48d19fc9e.png";
        String[] split = t.split("/");
        System.out.println(split);

        String t1 = "asldj-";
        String[] split1 = t1.split("-");
        System.out.println("split1 = " + split1);

        SimpleIdGenerator simpleIdGenerator = new SimpleIdGenerator();
        UUID uuid = simpleIdGenerator.generateId();
        System.out.println("uuid = " + uuid);
    }
}
