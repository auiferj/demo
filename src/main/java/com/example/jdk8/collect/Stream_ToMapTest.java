package com.example.jdk8.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_ToMapTest {
    public static void main(String[] args) {
        List<MyItem> arrayList = new ArrayList();
        Map<String, String> collect = arrayList.stream().collect(Collectors.toMap(MyItem::getField1, MyItem::getField2, (a, b) -> a));
        //这两返回的collect是一个空map,但不是null.
        System.out.println("collect = " + collect.get("field1"));
    }

    //内部类
    public static class MyItem {
        private String field1;
        private String field2;

        public MyItem(String field1, String field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        public String getField1() {
            return field1;
        }

        public String getField2() {
            return field2;
        }

        @Override
        public String toString() {
            return "MyItem{" +
                    "field1='" + field1 + '\'' +
                    ", field2='" + field2 + '\'' +
                    '}';
        }
    }
}
