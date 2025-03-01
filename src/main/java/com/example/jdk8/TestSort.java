package com.example.jdk8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class TestSort {
    public static void way(int num[],int n){

    }
    public static void main(String[] args) {
        Node node4=new Node(2,2);
        Node node3=new Node(2,1);
        Node node1=new Node(1,2);
        Node node2=new Node(1,1);
        Node node5=new Node(3,1);
        Node node6=new Node(3,2);
        ArrayList<Node> list=new ArrayList<>();
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.add(node5);
        list.add(node6);
        Collections.sort(list, new Comparator<Node>() {
            /**o1-o2为升序序排列，o2-o1为降序排列，若具体到某一字段，则根据该字段进行排列*/
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.x==o2.x) //若x属性相等，根据y来升序
                    return o1.y-o2.y;
                return o1.x-o2.x;//x属性不相等，根据x来升序排列
            }
        });
        //这样会报错，虽说Comparator.comparing返回的是一个Comparator实现，但是比较逻辑复杂，取不到y的值
        // Collections.sort(list,Comparator.comparing(o -> o.x,(x1,x2) -> {
        //     if(x1 == x2)return o2.y-o2.y;
        //     return x1-x2;
        // }));


        //Comparator接口实现可以用lambda表达式代替
        Collections.sort(list, (o1,o2) -> {
            if(o1.x == o2.x) return o1.y-o2.y;
            return o1.x-o2.x;
        });
        //在Java8种，List接口添加了默认方法sort,参数是一个接口Comparator的的实现，可以用lambda表达式代替
        list.sort((o1,o2) -> {
            if(o1.x == o2.x) return o1.y-o2.y;
            return o1.x-o2.x;
        });
        for (Node node:list) {
            System.out.println(node.toString());
        }
    }
}
