package com.example.jdk8;

import org.apache.logging.log4j.util.Strings;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestStructor {
    public static void main(String[] args) {
        Node node = new Node(1, 2);
        Map<String,String> map = new HashMap<>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        Collection<String> values = map.values();
        for (String value : values) {

        }

        Set<String> strings = map.keySet();
        for (String string : strings) {

        }

        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
        }
    }
}
