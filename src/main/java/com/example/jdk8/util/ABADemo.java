package com.example.jdk8.util;

import java.util.concurrent.atomic.AtomicStampedReference;

public class ABADemo {
    // 初始值为 100，初始版本号为 0
    private static AtomicStampedReference<Integer> atomicStampedRef = new AtomicStampedReference<>(100, 0);

    public static void main(String[] args) throws InterruptedException {
        System.out.println("初始值: " + atomicStampedRef.getReference() + ", 版本号: " + atomicStampedRef.getStamp());

        // 线程1：模拟ABA问题中的干扰线程
        Thread t1 = new Thread(() -> {
            // 模拟睡眠一下，让线程2先读到初始值
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // A -> B：将100改为101，版本号+1
            boolean success1 = atomicStampedRef.compareAndSet(100, 101,
                    atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("线程1 [A->B] 操作: " + success1 + ", 值: " + atomicStampedRef.getReference() + ", 版本号: " + atomicStampedRef.getStamp());

            // B -> A：将101改回100，版本号再+1
            boolean success2 = atomicStampedRef.compareAndSet(101, 100,
                    atomicStampedRef.getStamp(), atomicStampedRef.getStamp() + 1);
            System.out.println("线程1 [B->A] 操作: " + success2 + ", 值: " + atomicStampedRef.getReference() + ", 版本号: " + atomicStampedRef.getStamp());
        });

        // 线程2：尝试进行CAS操作的主线程
        Thread t2 = new Thread(() -> {
            int initialStamp = atomicStampedRef.getStamp(); // 先获取初始版本号 0
            int initialValue = atomicStampedRef.getReference(); // 获取初始值 100
            System.out.println("线程2 读取到初始值: " + initialValue + ", 版本号: " + initialStamp);

            // 模拟睡眠，确保线程1完成了它的ABA操作
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 尝试进行CAS操作：期望值100，期望版本号0 -> 新值200，新版本号+1
            // 此时，值虽然还是100，但版本号已经被线程1改了2次，变成了2。
            // 所以 expectedStamp (0) != currentStamp (2)，CAS操作会失败！
            boolean success = atomicStampedRef.compareAndSet(initialValue, 200,
                    initialStamp, initialStamp + 1);

            System.out.println("线程2 [A->C] 操作: " + success + ", 最终值: " + atomicStampedRef.getReference() + ", 最终版本号: " + atomicStampedRef.getStamp());
        });

        t2.start();
        t1.start();
        t1.join();
        t2.join();
    }
}
