package com.example.jdk8.proxy;

public class BubbleSort {

    public static void bobbleSort(int[] arr){
        int length = arr.length;
        //第一层遍历arr的所有元素
        for (int i = 0; i < length-1; i++) {
            //遍历arr[i]之后的所有元素
            for (int j = i+1; j < length; j++) {
                //如果arr[i]之后的某个元素比arr[i]小，则把该元素和arr[i]调换位置
                if(arr[j]<arr[i]){
                    int c = arr[i] + arr[j];
                    arr[i] = c - arr[i];
                    arr[j] = c - arr[j];
                }
            }
        }
        //最后会得到一个元素从小到大排列的数组
    }

    public static void main(String[] args) {
        int[] arr = {5,8,9,5,6,0,2,1,4};
        bobbleSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
