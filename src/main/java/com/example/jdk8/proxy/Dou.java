package com.example.jdk8.proxy;

public class Dou {
    public static int removeDuplicatesA(int[] A) {
        //边界条件判断
        if (A == null || A.length == 0)
            return 0;
        int left = 0;
        for (int right = 1; right < A.length; right++)
            //如果左指针和右指针指向的值一样，说明有重复的，
            //这个时候，左指针不动，右指针继续往右移。如果他俩
            //指向的值不一样就把右指针指向的值往前挪
            if (A[left] != A[right])
                A[++left] = A[right];
        return ++left;
    }

    public static int removeDuplicatesB(int[] B) {
        int count = 0;//重复的数字个数
        for (int right = 1; right < B.length; right++) {
            if (B[right] == B[right - 1]) {
                //如果有重复的，count要加1
                count++;
            } else {
                //如果没有重复，后面的就往前挪
                B[right - count] = B[right];
            }
        }
        //数组的长度减去重复的个数
        return B.length - count;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        removeDuplicatesA(nums);
    }
}
