package com.example.jdk8;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

public class SetTest {
    public static void main(String[] args) {

        HashSet<String> set = new HashSet<>();
        String users = "2011000510,2011000245,2011000153";
        String[] usersId = users.split(",");
        if (usersId != null && usersId.length>0) {
            for (String uid : usersId) {
                set.add(uid);
            }
        }

        List<String> result = new ArrayList<>(set);
        String collect = result.stream().collect(Collectors.joining(","));
        System.out.println(collect);

    }
}
